package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienLouable;
import modele.ChargesGenerales;
import modele.Compteur;
import modele.ContratLocation;
import modele.Locataire;
import modele.UtOracleDataSource;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienLouable;
import modele.dao.DaoChargesGenerales;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import vue.FenetreAjouterBatiment;
import vue.FenetreAssurance;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreLocataire;
import vue.FenetrePaiement;
import vue.FenetrePrincipale;

public class GestionFenetrePrincipale extends GestionHeaderEtFooter
    implements MouseListener {

    private FenetrePrincipale fenetre;
    private DaoBienLouable daoBienLouable;

    public GestionFenetrePrincipale(FenetrePrincipale fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    public List<ChargesGenerales> getDonneesChargesGenerale()
        throws SQLException {
        DaoChargesGenerales dao = new DaoChargesGenerales();
        String[] id = new String[1];
        id[0] = this.fenetre.getChosenBatiment();
        return dao.findByIdBatiment(id);
    }
    
    public List<Compteur> getDonneesCompteur() throws SQLException {
    	DaoCompteur dao = new DaoCompteur();
    	String[] id = new String[1];
    	id[0] = this.fenetre.getChosenBatiment();
    	return dao.findByIdBatiment(id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JComboBox) {
            fenetre.getTableBienLouable().clearSelection();
            viderTable();
            RemplirTableau();
        } else {
            super.actionPerformed(e);
        }
    }

    private void viderTable() {
        DefaultTableModel model = (DefaultTableModel) fenetre
            .getTableBienLouable()
            .getModel();
        model.setRowCount(0);
    }

    @Override
    protected void gererBoutonSpecifique(String texte) throws SQLException {
        switch (texte) {
        case "Quitter":
            fenetre.dispose();
            UtOracleDataSource.Deconnecter();
            break;

        case "Assurance":
            FenetreAssurance assurance = new FenetreAssurance();
            assurance.setVisible(true);
            fenetre.dispose();
            break;

        case "Compteurs":
            new FenetreCompteurs("FenPrincipale", this.getDonneesCompteur()).setVisible(true);
            fenetre.dispose();
            break;

        case "Charges":
            new FenetreCharges("FenPrincipale", getDonneesChargesGenerale())
                .setVisible(true);
            fenetre.dispose();
            break;

        case "Ajouter":
            FenetreAjouterBatiment ajout = new FenetreAjouterBatiment();
            fenetre.getLayeredPane().add(ajout);
            ajout.setVisible(true);
            break;
        case "Importer Un Fichier CSV":
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                System.out.println(
                    "Selected file: " + selectedFile.getAbsolutePath());
                mAJDeBaseDeDonnees(selectedFile);
            }
            break;
        }
    }

    private void mAJDeBaseDeDonnees(File file) {
        return;
    }

    @Override
    protected void gererMenuSpecifique(String texte) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
            JTable table = (JTable) e.getSource();
            int row = table.rowAtPoint(e.getPoint());
            int column = table.columnAtPoint(e.getPoint());
            int targetColumn = 0;
            if (row != -1 && column == targetColumn) {
                try {
                    String idCtrt = table.getValueAt(row, column).toString();
                    DaoBienLouable daoBL = new DaoBienLouable();
                    BienLouable bien = daoBL.findByIdContrat(idCtrt);
                    if (bien == null) {
                        JOptionPane.showMessageDialog(null, "Aucun bien louable trouvé pour ce contrat.");
                        return;
                    }
                    // pass the bien selected by the user here i have put here
                    // null but there must be a bien that the user clicked
                    FenetreBienLouable fen = new FenetreBienLouable("FenetrePrincipale", bien);
                    fen.setVisible(true);
                    fenetre.dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

       

       

    }

    public void remplirComboBatiment() {
        try {
            DaoBatiment daoBatiment = new DaoBatiment();
            List<Batiment> batiments = daoBatiment.findAll();

            JComboBox<String> combo = fenetre.getCbBatiment();
            combo.removeAllItems();

            for (Batiment b : batiments) {
                combo.addItem(b.getAdresse());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RemplirTableau() {
        try {
            daoBienLouable = new DaoBienLouable();
            String batiment = fenetre.getChosenBatiment();

            List<BienLouable> listBienLouable = daoBienLouable
                .findByBatiment(batiment);

            for (int i = 0; i < listBienLouable.size(); i++) {
                DaoContratLocation daoContrat = new DaoContratLocation();
                List<ContratLocation> listContrat = daoContrat
                    .findByBienLouable(
                        listBienLouable.get(i).getIdBienLouable());

                if (listContrat != null && !listContrat.isEmpty()) {
                    EcrireLigneTableBienLouable(i, listBienLouable.get(i),
                        listContrat.get(0));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EcrireLigneTableBienLouable(int numeroLigne,
        BienLouable bienLouable, ContratLocation contrat) throws SQLException {
        DaoLocataire daoLocataire = new DaoLocataire();
        List<Locataire> listLocataire = daoLocataire
            .findLocataireByContrat(contrat.getNumeroDeContrat());
        JTable table = fenetre.getTableBienLouable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getColumnCount() == 0) {
            model.setColumnIdentifiers(new String[] { "Contrat Location",
                "Nombre de piece", "Bien Louable", "Locataire Référent" });
        }
        if (model.getRowCount() == numeroLigne) {
            model.addRow(new Object[] { null, null, null, null });
        }
        model.setValueAt(contrat.getNumeroDeContrat(), numeroLigne, 0);
        model.setValueAt(bienLouable.getNbPieces(), numeroLigne, 1);
        model.setValueAt(bienLouable.getTypeBienLouable(), numeroLigne, 2);
        model.setValueAt(listLocataire.get(0).getNomComplet(), numeroLigne, 3);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
