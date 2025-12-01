package controleur;

import java.awt.event.ActionListener;

import vue.*;

public class GestionFenetreCompteurs extends GestionHeaderEtFooter implements ActionListener{

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
    protected void gererMenuSpecifique(String texte) {
    }
}
