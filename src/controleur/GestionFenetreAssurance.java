package controleur;
import java.sql.SQLException;

import modele.Assurance;
import modele.Batiment;
import modele.dao.DaoAssurance;
import modele.dao.DaoBatiment;
import vue.FenetreAjouterAssurance;
import vue.FenetreAssurance;
import vue.FenetrePrincipale;

public class GestionFenetreAssurance extends GestionHeaderEtFooter {

    private FenetreAssurance fenetre;
    private String bat;

    public GestionFenetreAssurance(FenetreAssurance fenetre) {
    	super(fenetre);
        this.fenetre = fenetre;
        this.bat = this.fenetre.getBat();
    }
    
    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Ajouter assurance":
			try {
            	DaoBatiment dao = new DaoBatiment();
				Batiment b = dao.findById(this.bat);
				FenetreAjouterAssurance fenAjouterAssurance = new FenetreAjouterAssurance(b);
                fenetre.getLayeredPane().add(fenAjouterAssurance);
                fenAjouterAssurance.setVisible(true);
                break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                
        }
    }
    
    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            FenetrePrincipale fp = new FenetrePrincipale();
            fp.setVisible(true);
            fenetre.dispose();
        }
    }
    
    public void chargerAssuranceBatiment(String batiment) throws SQLException {
        DaoAssurance daoAssurance = new DaoAssurance();
        Assurance assurance = daoAssurance.findByBatiment(batiment);
        try {
            int nbBiens = daoAssurance.countBiensAssures(batiment);
            this.afficherAssuranceBatiment(assurance, nbBiens);
        } catch (SQLException e) {
            e.printStackTrace();
            this.afficherAssuranceBatiment(assurance, 0);
        }

    }
    
	public void afficherAssuranceBatiment(Assurance assurance, int nbBiens) {
	    this.fenetre.getTextFieldNumAssurance().setText(assurance.getNumeroAssurance());
	    this.fenetre.getTxtFieldPrime().setText(String.valueOf(assurance.getPrime()));
	    this.fenetre.getTxtFieldType().setText(assurance.getTypeAssurance());
	    this.fenetre.getTextFieldAgence().setText(assurance.getAgence());
	    this.fenetre.getTextFieldTelAgence().setText(assurance.getAdresseAgence());
	    this.fenetre.getTextFieldTelAgence().setText(assurance.getTelAgence());
	    this.fenetre.getLblNbBien().setText(String.valueOf(nbBiens));
	    this.fenetre.getTxtFieldMontant().setText(String.valueOf(assurance.getMontant()));
	    this.fenetre.getTextFieldAdresseAgence().setText(assurance.getAdresseAgence());
	}


}
