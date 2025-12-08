package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTable;

import vue.*;

public class GestionFenetrePrincipale extends GestionHeaderEtFooter implements MouseListener{

    private FenetrePrincipale fenetre;

    public GestionFenetrePrincipale(FenetrePrincipale fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }
    
    
    @Override
    protected void gererBoutonSpecifique(String texte) {
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
                new FenetreCharges("FenetrePrincipale").setVisible(true);
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
    	    int targetColumn = 2;
    	    if (row != -1 && column == targetColumn) {
    	        fenetre.dispose();
    	        FenetreBienLouable fen = new FenetreBienLouable();
    	        fen.setVisible(true);
    	    }
    	}
    	
    	if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
    	    JTable table = (JTable) e.getSource();
    	    int row = table.rowAtPoint(e.getPoint());
    	    int column = table.columnAtPoint(e.getPoint()); 
    	    int targetColumn = 3;
    	    if (row != -1 && column == targetColumn) {
    	        fenetre.dispose();
    	        FenetreLocataire fen = new FenetreLocataire("FenetrePrincipale");
    	        fen.setVisible(true);
    	    }
    	}

        if(e.getSource() == fenetre.getPanelRevenu()) {
        	FenetreContratLocation fCL = new FenetreContratLocation("FenPrincipale");
        	fCL.setVisible(true);
        }
        if(e.getSource() == fenetre.getPanelNbLoyerPasPaye()) {
        	FenetreBienLouable fBL = new FenetreBienLouable();
        	fBL.setVisible(true);
        }
        if(e.getSource() == fenetre.getPanelRevenu_1()) {
        	FenetrePaiement fp = new FenetrePaiement();
        	fp.setVisible(true);
        }
        if(e.getSource() == fenetre.getPanelNbLoyePasPaye_1()) {
        	FenetreContratLocation fCL = new FenetreContratLocation("FenPrincipale");
        	fCL.setVisible(true);
        }
        
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
