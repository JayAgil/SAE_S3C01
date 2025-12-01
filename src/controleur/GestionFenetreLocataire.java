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
                fenetre.dispose();
                new FenetrePaiement().setVisible(true);
                break;
        }
    }

}
