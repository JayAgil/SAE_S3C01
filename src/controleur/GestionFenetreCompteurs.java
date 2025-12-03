package controleur;

import vue.*;

public class GestionFenetreCompteurs extends GestionHeaderEtFooter {

    private FenetreCompteurs fenetre;

    public GestionFenetreCompteurs(FenetreCompteurs fenetre) {
        super(fenetre);
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Ajouter compteur":
                FenetreAjouterCompteur fenAjouterCompteur = new FenetreAjouterCompteur();
                fenetre.getLayeredPane().add(fenAjouterCompteur);
                fenAjouterCompteur.setVisible(true);
                break;
        }
    }

    @Override
    protected void gererBoutonRetour(String texte) {
    	if ("Retour".equals(texte)) {
    		FenetrePrincipale fp = new FenetrePrincipale();
        	fp.setVisible(true);
        	fenetre.dispose();
    	}
    		
    }
}
