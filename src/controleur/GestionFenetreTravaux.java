package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import modele.Facture;
import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterTravaux;
import vue.FenetreBienLouable;
import vue.FenetreFacture;
import vue.FenetreTravaux;

public class GestionFenetreTravaux extends GestionHeaderEtFooter implements MouseListener {

    private FenetreTravaux fenetreTravaux;

    public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
        super(fenetreTravaux);
        this.fenetreTravaux = fenetreTravaux;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object source = e.getSource();
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
    	int row = fenetreTravaux.getTable().getSelectedRow();
    	if (row == -1) {
    	    JOptionPane.showMessageDialog(fenetreTravaux, "Veuillez sélectionner une facture");
    	    return;
    	}
    	Facture facture = fenetreTravaux.getFactureSelectionnee(row);
    	new FenetreFacture(facture).setVisible(true);

    }

    @Override
    protected void gererBoutonRetour(String texte) throws SQLException {
        if ("Retour".equals(texte)) {
            FenetreBienLouable fen = new FenetreBienLouable("fp", null);
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

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
