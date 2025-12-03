package controleur;
import vue.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter{

    private FenetreContratLocation fenetre;

    public GestionFenetreContratLocation(FenetreContratLocation fenetre) {
        super(fenetre);
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
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            FenetreBienLouable fp = new FenetreBienLouable();
            fp.setVisible(true);
            fenetre.dispose();      
        }
    }
}
