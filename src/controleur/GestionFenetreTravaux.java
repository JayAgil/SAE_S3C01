package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Facture;
import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterTravaux;
import vue.FenetreBienLouable;
import vue.FenetreFacture;
import vue.FenetreTravaux;

public class GestionFenetreTravaux extends GestionHeaderEtFooter implements MouseListener {

    private FenetreTravaux fenetreTravaux;
    private List<Facture> travaux;

    public GestionFenetreTravaux(FenetreTravaux fenetreTravaux, List<Facture> liste) {
        super(fenetreTravaux);
        this.fenetreTravaux = fenetreTravaux;
        this.travaux = liste;
        chargerDonnes();
        majDonnees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object source = e.getSource();
        if (source == fenetreTravaux.getComboBox_Mois() || source == fenetreTravaux.getComboBox_Annee()) {
            filtrerTravaux();
            return;
        }
        
        if (!(source instanceof JButton)) return;
        
        JButton btn = (JButton) source;
        switch (btn.getText()) {
            case "Ajouter travaux":
                ouvrirFenetreAjouterTravaux();
                break;
            case "Ajouter entreprise":
                ouvrirFenetreAjouterEntreprise();
                break;
            case "Visualiser facture":
                visualiserFactureSelectionnee();
                break;
        }
    }

    private void ouvrirFenetreAjouterTravaux() {
        FenetreAjouterTravaux fen = new FenetreAjouterTravaux();
        fenetreTravaux.getLayeredPane().add(fen);
        fen.setVisible(true);
    }

    private void ouvrirFenetreAjouterEntreprise() {
        FenetreAjouterEntreprise fen = new FenetreAjouterEntreprise();
        fenetreTravaux.getLayeredPane().add(fen);
        fen.setVisible(true);
    }

    private void visualiserFactureSelectionnee() {
        Facture facture = fenetreTravaux.getFactureSelectionnee();
        if (facture == null) {
            JOptionPane.showMessageDialog(fenetreTravaux, "Veuillez sélectionner une facture");
            return;
        }
        new FenetreFacture(facture).setVisible(true);
    }

    @Override
    protected void gererBoutonRetour(String texte) throws SQLException {
        if ("Retour".equals(texte)) {
            FenetreBienLouable fen = new FenetreBienLouable("FenPrincipale", this.fenetreTravaux.getBien());
            fen.setVisible(true);
            fenetreTravaux.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
            JTable table = (JTable) e.getSource();
            int row = table.rowAtPoint(e.getPoint());
            if (row != -1) {
                Facture facture = fenetreTravaux.getFactureSelectionnee(row);
                if (facture != null) {
                    new FenetreFacture(facture).setVisible(true);
                }
            }
        }
    }
    
    private void chargerDonnes() {
		JTable table = this.fenetreTravaux.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); 
		for (Facture f : travaux) {
			Object[] ligne = { f.getNumeroFacture(),f.getMontant(),f.getDateDeFacture(),f.getCompteBancaire(),f.getMontantDevis(),f.getDatePaiement(),f.getDesignationDeTravaux(),f.getEntreprise().getNom() };
			model.addRow(ligne);
		}

	}
    
    private void majDonnees() {
    	double somme = 0;
    	for (Facture f : travaux) {
    		somme += f.getMontant();
    	}
    	
    	this.fenetreTravaux.getLblMontantTotal().setText(String.valueOf(somme) + "€");
    	this.fenetreTravaux.getLblNbTravaux().setText(String.valueOf(travaux.size()));
    }
    
    private void filtrerTravaux() {
        String moisSelectionne = (String) fenetreTravaux.getComboBox_Mois().getSelectedItem();
        String anneeSelectionnee = (String) fenetreTravaux.getComboBox_Annee().getSelectedItem();
        JTable table = fenetreTravaux.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        double somme = 0;
        int nbTravaux = 0;
        
        for (Facture f : travaux) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(f.getDateDeFacture());
            int moisFacture = cal.get(java.util.Calendar.MONTH) + 1; // January = 0
            int anneeFacture = cal.get(java.util.Calendar.YEAR);

            boolean match = true;

            if (!"Tous".equals(moisSelectionne)) {
                int moisCombo = getMoisInt(moisSelectionne);
                match = match && (moisFacture == moisCombo);
            }

            if (!"Tous".equals(anneeSelectionnee)) {
                int anneeCombo = Integer.parseInt(anneeSelectionnee);
                match = match && (anneeFacture == anneeCombo);
            }
            if (match) {
                Object[] ligne = {
                    f.getNumeroFacture(),
                    f.getMontant(),
                    f.getDateDeFacture(),
                    f.getCompteBancaire(),
                    f.getMontantDevis(),
                    f.getDatePaiement(),
                    f.getDesignationDeTravaux(),
                    f.getEntreprise().getNom()
                };
                model.addRow(ligne);

                somme += f.getMontant();
                nbTravaux++;
            }
        }

        fenetreTravaux.getLblMontantTotal().setText(String.valueOf(somme) + "€");
        fenetreTravaux.getLblNbTravaux().setText(String.valueOf(nbTravaux));
    }
    private int getMoisInt(String mois) {
        switch (mois) {
            case "Janvier": return 1;
            case "Février": return 2;
            case "Mars": return 3;
            case "Avril": return 4;
            case "Mai": return 5;
            case "Juin": return 6;
            case "Juillet": return 7;
            case "Août": return 8;
            case "Septembre": return 9;
            case "Octobre": return 10;
            case "Novembre": return 11;
            case "Décembre": return 12;
            default: return 0;
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
