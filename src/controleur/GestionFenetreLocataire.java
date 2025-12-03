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
            if(fenetre.getNomFenAvant() == "Principale") {
	            FenetrePrincipale fp = new FenetrePrincipale();
	            fp.setVisible(true);
            }
            if(fenetre.getNomFenAvant() == "BienLouable") {
	            FenetreBienLouable fp = new FenetreBienLouable();
	            fp.setVisible(true);
            }
        }
    }

}
