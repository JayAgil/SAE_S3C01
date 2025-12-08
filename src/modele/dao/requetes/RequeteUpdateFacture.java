package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

public class RequeteUpdateFacture extends Requete<Facture> {
	
	 @Override
	    public String requete() {
	        return "Update MSF5131A.SAE_Facture set Montant = ?,"
	        		+ "Date_de_facture = ?, Compte_Bancaire = ?,"
	        		+ "Montant_Devis = ?, Date_Paiement = ?"
	        		+ "Designation_de_travaux = ?"
	        		+ "Where Numero_Facture = ?";

	    }

	    @Override
	    public void parametres(PreparedStatement prSt, String... id)
	        throws SQLException {
	    }

	    @Override
	    public void parametres(PreparedStatement prSt, Facture donnee)
	        throws SQLException {
	        prSt.setDouble(1, donnee.getMontant());
	        prSt.setDate(2, donnee.getDateDeFacture());
	        prSt.setString(3, donnee.getCompteBancaire());
	        prSt.setDouble(4, donnee.getMontantDevis());
	        prSt.setDate(5, donnee.getDatePaiement());
	        prSt.setString(6, donnee.getDesignationDeTravaux());
	        
	    }

}
