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
            fenetre.dispose();
            FenetreLocataire fen = new FenetreLocataire("Paiement");
            fen.setVisible(true);
        }
    }
}
