package controleur;

import vue.*;

public class GestionFenetreLocataire extends GestionHeaderEtFooter {

    private FenetreLocataire fenetre;

    public GestionFenetreLocataire(FenetreLocataire fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter locataire":
                FenetreAjouterLocataire fenAjouterLocataire = new FenetreAjouterLocataire();
                fenetre.getLayeredPane().add(fenAjouterLocataire);
                fenAjouterLocataire.setVisible(true);
                break;
            case "Paiement":
                new FenetrePaiement().setVisible(true);
                fenetre.dispose();
                break;
        }
    }
    
    @Override
    protected void gererBoutonRetour(String texte) {
    	if ("Retour".equals(texte)) {
    	    fenetre.dispose();
    	    String fenAvant = fenetre.getNomFenAvant();

    	    switch (fenAvant) {
    	        case "FenetrePrincipale":
    	            FenetrePrincipale fp1 = new FenetrePrincipale();
    	            fp1.setVisible(true);
    	            break;
    	        case "BienLouable":
    	            FenetreBienLouable fp2 = new FenetreBienLouable();
    	            fp2.setVisible(true);
    	            break;
    	        case "FenContratLocation":
    	            FenetreContratLocation fp3 = new FenetreContratLocation("FenBienLouable");
    	            fp3.setVisible(true);
    	            break;
    	        default:
    	            FenetreBienLouable fpDefault = new FenetreBienLouable();
    	            fpDefault.setVisible(true);
    	            break;
    	    }
    	}
    }

}
