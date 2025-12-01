package controleur;

import vue.*;
import javax.swing.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter {

    private FenetreContratLocation fenetre;

    public GestionFenetreContratLocation(FenetreContratLocation fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter":
                break;

            case "Annuler":
                fenetre.dispose();
                break;
        }
    }

}
