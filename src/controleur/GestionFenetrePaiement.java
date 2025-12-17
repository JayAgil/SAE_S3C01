package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.*;

public class GestionFenetrePaiement extends GestionHeaderEtFooter implements MouseListener{

    private FenetrePaiement fenetre;

    public GestionFenetrePaiement(FenetrePaiement fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter paiement":
                FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
                fenetre.getLayeredPane().add(fenAjouterPaiement);
                fenAjouterPaiement.setVisible(true);
                break;
        }
    }

    
    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            FenetreLocataire fen = new FenetreLocataire("Paiement",fenetre.getLocataires());
            fen.setVisible(true);
            fenetre.dispose();
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
