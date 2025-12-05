package controleur;
import vue.FenetreAjouterAssurance;
import vue.FenetreAssurance;
import vue.FenetrePrincipale;

public class GestionFenetreAssurance extends GestionHeaderEtFooter {

    private FenetreAssurance fenetre;

    public GestionFenetreAssurance(FenetreAssurance fenetre) {
    	super(fenetre);
        this.fenetre = fenetre;
    }
    
    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Ajouter assurance":
                FenetreAjouterAssurance fenAjouterAssurance = new FenetreAjouterAssurance();
                fenetre.getLayeredPane().add(fenAjouterAssurance);
                fenAjouterAssurance.setVisible(true);
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
