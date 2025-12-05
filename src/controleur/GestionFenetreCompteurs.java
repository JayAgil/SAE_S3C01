package controleur;

import vue.*;

public class GestionFenetreCompteurs extends GestionHeaderEtFooter {

    private FenetreCompteurs fenetre;

    public GestionFenetreCompteurs(FenetreCompteurs fenetre) {
        super(fenetre);
        this.fenetre = fenetre;

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
    	    fenetre.dispose();
    	    String fenAvant = fenetre.getFenetreAvant();

    	    switch (fenAvant) {
    	        case "FenetrePrincipale":
    	            FenetrePrincipale fp1 = new FenetrePrincipale();
    	            fp1.setVisible(true);
    	            break;
    	        case "FenetreBienLouable":
    	            FenetreBienLouable fp2 = new FenetreBienLouable();
    	            fp2.setVisible(true);
    	            break;
    	        default:
    	            FenetreBienLouable fpDefault = new FenetreBienLouable();
    	            fpDefault.setVisible(true);
    	            break;
    	    }
    	}
    		
    }
}
