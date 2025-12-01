package controleur;

import vue.*;

public class GestionFenetrePaiement extends GestionHeaderEtFooter {

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

            case "Generer le Facture":
                FenetreFacture fenFacture = new FenetreFacture();
                fenetre.getLayeredPane().add(fenFacture);
                fenFacture.setVisible(true);
                break;
        }
    }
}
