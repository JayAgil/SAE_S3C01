package controleur;
import java.sql.SQLException;

import modele.Assurance;
import modele.Batiment;
import modele.dao.DaoAssurance;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienLouable;
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
				FenetreAjouterAssurance fenAjouterAssurance = new FenetreAjouterAssurance(b,this);
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
        DaoBienLouable dB = new DaoBienLouable();
        Assurance assurance = daoAssurance.findByBatiment(batiment);
        int nbBiens = dB.findByIdBat(batiment).size();
        this.afficherAssuranceBatiment(assurance, nbBiens);
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
