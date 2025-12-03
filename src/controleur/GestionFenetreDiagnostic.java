package controleur;
import vue.*;

public class GestionFenetreDiagnostic extends GestionHeaderEtFooter {

    private FenetreDiagnostic fenetre;

    public GestionFenetreDiagnostic(FenetreDiagnostic fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "obtenir":
                fenetre.dispose();
                break;
            case "Retour" :
            	FenetreBienLouable fenBienLouable = new FenetreBienLouable();
	            fenBienLouable.setVisible(true);
	            fenetre.dispose();
	            break;
        }
    }

    protected void gererMenuSpecifique(String texte) {
    }
}
