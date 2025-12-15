package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.ChargesGenerales;
import modele.ContratLocation;
import modele.dao.DaoBienLouable;
import modele.dao.DaoChargesGenerales;
import modele.dao.DaoContratLocation;
import vue.*;

public class GestionFenetrePrincipale extends GestionHeaderEtFooter implements MouseListener{

    private FenetrePrincipale fenetre;
	private DaoBienLouable daoBienLouable;

    public GestionFenetrePrincipale(FenetrePrincipale fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }
    
    public List<ChargesGenerales> getDonneesChargesGenerale() throws SQLException {
        DaoChargesGenerales dao = new DaoChargesGenerales();
        String[] id = new String[1];
        id[0] = this.fenetre.getChosenBatiment();
        return dao.findAll();
    }
    
    @Override
    protected void gererBoutonSpecifique(String texte) throws SQLException {
        switch (texte) {
            case "Quitter":
                fenetre.dispose();
                break;

            case "Assurance":
                FenetreAssurance assurance = new FenetreAssurance();
                assurance.setVisible(true);
                fenetre.dispose();            
                break;

            case "Compteurs":
                new FenetreCompteurs("FenetrePrincipale").setVisible(true);
                fenetre.dispose();
                break;

            case "Charges":
                new FenetreCharges("FenetrePrincipale", getDonneesChargesGenerale()).setVisible(true);
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
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    mAJDeBaseDeDonnees(selectedFile);
            	break;
            	}
            case "Généré":
                this.daoBienLouable = new DaoBienLouable();
                List<BienLouable> listBienLouable;
                try {
                    listBienLouable = daoBienLouable.findAll();
                    for (int i = 0; i < listBienLouable.size(); i++) {
                        EcrireLigneTableBienLouable(i, listBienLouable.get(i));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
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
    public void mouseClicked(MouseEvent e){
    	if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
    	    JTable table = (JTable) e.getSource();
    	    int row = table.rowAtPoint(e.getPoint());
    	    int column = table.columnAtPoint(e.getPoint()); 
    	    int targetColumn = 2;
    	    if (row != -1 && column == targetColumn) {
    	        fenetre.dispose();
    	        FenetreBienLouable fen;
				try {
					String idBien = table.getValueAt(row, column).toString();
					DaoBienLouable daoBL = new DaoBienLouable();
					BienLouable bien = daoBL.findById(idBien);
					// pass the bien selected by the user here i have put here null but there must be a bien that the user clicked
					fen = new FenetreBienLouable("FenetrePrincipale", bien);
	    	        fen.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    	    }
    	}
    	
    	if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
    	    JTable table = (JTable) e.getSource();
    	    int row = table.rowAtPoint(e.getPoint());
    	    int column = table.columnAtPoint(e.getPoint()); 
    	    int targetColumn = 3;
    	    if (row != -1 && column == targetColumn) {
    	        fenetre.dispose();
    	        FenetreLocataire fen = new FenetreLocataire("FenetrePrincipale", null);
    	        fen.setVisible(true);
    	    }
    	}

        if(e.getSource() == fenetre.getPanelRevenu()) {
        	FenetreContratLocation fCL = new FenetreContratLocation("FenPrincipale");
        	fCL.setVisible(true);
        }
        if(e.getSource() == fenetre.getPanelNbLoyerPasPaye()) {
        	FenetreBienLouable fBL;
			try {
				fBL = new FenetreBienLouable("FenetrePrincipale", null);
	        	fBL.setVisible(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        }
        if(e.getSource() == fenetre.getPanelRevenu_1()) {
        	FenetrePaiement fp = new FenetrePaiement(null);
        	fp.setVisible(true);
        }
        if(e.getSource() == fenetre.getPanelNbLoyePasPaye_1()) {
        	FenetreContratLocation fCL = new FenetreContratLocation("FenPrincipale");
        	fCL.setVisible(true);
        }
        
    }
    
    public void EcrireLigneTableBienLouable(int numeroLigne,
            BienLouable bienLouable) throws SQLException {
            JTable table = fenetre.getTableBienLouable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if (model.getColumnCount() == 0) {
                model.setColumnIdentifiers(new String[] { "Contrat Location",
                    "Date", "Bien Louable", "Locataire Référent" });
            }
            model.setRowCount(0);
            while (model.getRowCount() <= numeroLigne) {
                model.addRow(new Object[] { null, null, null, null });
            }
            DaoContratLocation daoContrat = new DaoContratLocation();
            List<ContratLocation> listContrat = daoContrat
                .findByBienLouable(bienLouable.getIdBienLouable());
            if (listContrat != null) {
                model.setValueAt(listContrat.get(0).getNumeroDeContrat(),
                    numeroLigne, 0);
                model.setValueAt(bienLouable.getNbPieces(), numeroLigne, 1);
                model.setValueAt(bienLouable.getTypeBienLouable(), numeroLigne, 2);
                model.setValueAt(bienLouable.getSurfaceHabituable(), numeroLigne,
                    3);
            }
        }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
