package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Compteur;

public class RequeteSelectCompteurByBatiment extends Requete<Compteur> {

	@Override
	public String requete() {
		return "SELECT c.* " +
			    	    "FROM MSF5131A.SAE_Batiment bat " +
			    	    "JOIN MSF5131A.SAE_BienLouable b ON b.fk_Adresse_Bat = bat.Adresse " +
			    	    "JOIN MSF5131A.SAE_Compteur c ON c.fk_Id_BienLouable = b.Id_BienLouable " +
			    	    "WHERE bat.Adresse = ? "
			    	    + "Order by Index_nouveau DESC";

	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
