package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JTable;

import modele.ContratLocation;
import vue.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter implements MouseListener{

    private FenetreContratLocation fenetre;
    private ContratLocation cl;

    public GestionFenetreContratLocation(FenetreContratLocation fenetre, ContratLocation cl) {
        super(fenetre);
        this.fenetre = fenetre;
        this.cl = cl;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Ajouter":
                FenetreAjouterContratLocation fACL = new FenetreAjouterContratLocation();
                fenetre.getLayeredPane().add(fACL).setVisible(true);
                break;
            case "Annuler":
                fenetre.dispose();
                break;
        }
    }
    @Override
    protected void gererMenuSpecifique(String texte) {
    }
    
    @Override
    protected void gererBoutonRetour(String texte) throws SQLException {
        if ("Retour".equals(texte)) {
        	if(fenetre.getFenDavant().equals("FenBienLouable")) {
	            FenetreBienLouable fp = new FenetreBienLouable(null, null);
	            fp.setVisible(true);
	            fenetre.dispose();
        	}
        	if(fenetre.getFenDavant().equals("FenPrincipale")) {
	            FenetrePrincipale fp = new FenetrePrincipale();
	            fp.setVisible(true);
	            fenetre.dispose();
        	}
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
    	    JTable table = (JTable) e.getSource();
    	    int row = table.rowAtPoint(e.getPoint());
    	    int column = table.columnAtPoint(e.getPoint()); 
    	    int targetColumn = 0;
    	    if (row != -1 && column == targetColumn) {
    	        fenetre.dispose();
    	        FenetreLocataire fen = new FenetreLocataire("FenContratLocation", null);
    	        fen.setVisible(true);
    	    }
    	}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
