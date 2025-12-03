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
            FenetrePrincipale fp = new FenetrePrincipale();
            fp.setVisible(true);
        }
    }

}
