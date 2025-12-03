package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;

import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterTravaux;
import vue.FenetreBienLouable;
import vue.FenetreFacture;
import vue.FenetreTravaux;

public class GestionFenetreTravaux extends GestionHeaderEtFooter implements MouseListener {
	
	private FenetreTravaux fenetreTravaux;
	
	public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
		super(fenetreTravaux);
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Object source = e.getSource();
		// JButton
		if (source instanceof JButton) {
			JButton btn = (JButton) source;
	        String texte = btn.getText();
	        switch (texte) {
	        case "Ajouter travaux" :
				FenetreAjouterTravaux fenetreAjouterTravaux = new FenetreAjouterTravaux();
				fenetreTravaux.getLayeredPane().add(fenetreAjouterTravaux);
				fenetreAjouterTravaux.setVisible(true);	
				break;
			case "Ajouter entreprise" :
				FenetreAjouterEntreprise fenetreAjouterEntreprise = new FenetreAjouterEntreprise();
				fenetreTravaux.getLayeredPane().add(fenetreAjouterEntreprise);
				fenetreAjouterEntreprise.setVisible(true);
				break;
			case "Générer facture" :
				FenetreFacture fen = new FenetreFacture();
				fenetreTravaux.getLayeredPane().add(fen);
				fen.setVisible(true);
				break;
	        }
	     }
	}
	
	@Override
	protected void gererBoutonRetour(String texte) {
		if ("Retour".equals(texte)) {
			FenetreBienLouable fenetreBienLouable = new FenetreBienLouable();
			fenetreBienLouable.setVisible(true);
			fenetreTravaux.dispose();
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
    	        FenetreFacture fen = new FenetreFacture();
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
