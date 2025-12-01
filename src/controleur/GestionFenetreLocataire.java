package controleur;

import java.awt.event.ActionListener;

import vue.*;

public class GestionFenetreLocataire extends GestionHeaderEtFooter implements ActionListener{

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
<<<<<<< HEAD
            fenetre.dispose();
            if(fenetre.getNomFenAvant() == "Principale") {
	            FenetrePrincipale fp = new FenetrePrincipale();
	            fp.setVisible(true);
            }
            if(fenetre.getNomFenAvant() == "BienLouable") {
	            FenetreBienLouable fp = new FenetreBienLouable();
	            fp.setVisible(true);
            }
=======
            FenetreBienLouable fp = new FenetreBienLouable();
            fp.setVisible(true);
            fenetre.dispose();
>>>>>>> 5285a853d578134fc700a9805029302e2c41d341
        }
    }

}
