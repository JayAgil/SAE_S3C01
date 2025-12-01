package controleur;

import vue.*;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter {

    private FenetreBienLouable fenetrebienlouable;

    public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
        super(fenetre);
        this.fenetrebienlouable = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {

            case "Diagnostics":
                fenetrebienlouable.dispose();
                new FenetreDiagnostic().setVisible(true);
                break;

            case "Contrat":
                fenetrebienlouable.dispose();
                new FenetreContratLocation().setVisible(true);
                break;

            case "Charges":
                fenetrebienlouable.dispose();
                new FenetreCharges().setVisible(true);
                break;

            case "Travaux":
                fenetrebienlouable.dispose();
                new FenetreTravaux().setVisible(true);
                break;

            case "Compteur":
                fenetrebienlouable.dispose();
                new FenetreCompteurs().setVisible(true);
                break;

            case "Revaloriser":
                break;
        }
    }
}
