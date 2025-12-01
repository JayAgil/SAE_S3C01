package controleur;

import java.awt.event.ActionListener;

import vue.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter implements ActionListener{

    private FenetreContratLocation fenetre;

    public GestionFenetreContratLocation(FenetreContratLocation fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
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
            fenetre.dispose();
            FenetreBienLouable fp = new FenetreBienLouable();
            fp.setVisible(true);
        }
    }
}
