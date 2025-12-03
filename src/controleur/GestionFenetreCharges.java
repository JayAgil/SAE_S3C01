package controleur;
import vue.*;

public class GestionFenetreCharges extends GestionHeaderEtFooter{

    private FenetreCharges fenetre;

    public GestionFenetreCharges(FenetreCharges fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }
   

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter charge":
                FenetreAjouterCharge fenAjouterCharge = new FenetreAjouterCharge();
                fenetre.getLayeredPane().add(fenAjouterCharge);
                fenAjouterCharge.setVisible(true);
                break;

            case "Quitter":
                fenetre.dispose();
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
