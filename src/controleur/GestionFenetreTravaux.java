package controleur;

import java.awt.event.ActionListener;
import vue.*;

public class GestionFenetreTravaux extends GestionHeaderEtFooter implements ActionListener {

    public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
        super(fenetreTravaux);   
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Ajouter travaux":
                FenetreAjouterTravaux f1 = new FenetreAjouterTravaux();
                fenetre.getLayeredPane().add(f1);    
                f1.setVisible(true);
                break;

            case "Ajouter entreprise":
                FenetreAjouterEntreprise f2 = new FenetreAjouterEntreprise();
                fenetre.getLayeredPane().add(f2);
                f2.setVisible(true);
                break;

            case "Générer facture":
                FenetreFacture f3 = new FenetreFacture();
                fenetre.getLayeredPane().add(f3);
                f3.setVisible(true);
                break;
        }
    }

    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            fenetre.dispose();
            new FenetreBienLouable().setVisible(true);
        }
    }
}
