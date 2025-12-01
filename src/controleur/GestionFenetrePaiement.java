package controleur;

import java.awt.event.ActionListener;

import vue.*;

public class GestionFenetrePaiement extends GestionHeaderEtFooter implements ActionListener{

    private FenetrePaiement fenetre;

    public GestionFenetrePaiement(FenetrePaiement fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter paiement":
                FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
                fenetre.getLayeredPane().add(fenAjouterPaiement);
                fenAjouterPaiement.setVisible(true);
                break;

            case "Générer facture":
                FenetreFacture fenFacture = new FenetreFacture();
                fenetre.getLayeredPane().add(fenFacture);
                fenFacture.setVisible(true);
                break;
        }
    }
    
    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
<<<<<<< HEAD
            fenetre.dispose();
            FenetreLocataire fen = new FenetreLocataire("Paiement");
=======
            FenetreLocataire fen = new FenetreLocataire();
>>>>>>> 5285a853d578134fc700a9805029302e2c41d341
            fen.setVisible(true);
            fenetre.dispose();
        }
    }
}
