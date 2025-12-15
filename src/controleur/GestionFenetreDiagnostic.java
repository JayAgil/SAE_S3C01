package controleur;
import java.sql.SQLException;

import vue.*;

public class GestionFenetreDiagnostic extends GestionHeaderEtFooter {

    private FenetreDiagnostic fenetre;

    public GestionFenetreDiagnostic(FenetreDiagnostic fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) throws SQLException {
        switch (texte) {
            case "Ajouter":
                FenetreAjouterDiagnostic fenAjouterDiagnostic = new FenetreAjouterDiagnostic();
                fenAjouterDiagnostic.setVisible(true);
                break;
            case "Retour" :
            	FenetreBienLouable fenBienLouable = new FenetreBienLouable(null, null);
	            fenBienLouable.setVisible(true);
	            fenetre.dispose();
	            break;
        }
    }

    protected void gererMenuSpecifique(String texte) {
    }
}
