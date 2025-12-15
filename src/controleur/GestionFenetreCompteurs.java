package controleur;

import java.sql.SQLException;

import vue.*;

public class GestionFenetreCompteurs extends GestionHeaderEtFooter {

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
    protected void gererBoutonRetour(String texte) throws SQLException {
    	if ("Retour".equals(texte)) {
    	    fenetre.dispose();
    	    String fenAvant = fenetre.getFenetreAvant();

    	    switch (fenAvant) {
    	        case "FenetrePrincipale":
    	            FenetrePrincipale fp1 = new FenetrePrincipale();
    	            fp1.setVisible(true);
    	            break;
    	        case "FenetreBienLouable":
    	            FenetreBienLouable fp2 = new FenetreBienLouable(null, null);
    	            fp2.setVisible(true);
    	            break;
    	        default:
				FenetreBienLouable fpDefault;
				try {
					fpDefault = new FenetreBienLouable(null, null);
    	            fpDefault.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    	            break;
    	    }
    	}
    		
    }
}
