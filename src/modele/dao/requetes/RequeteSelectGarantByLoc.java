package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

public class RequeteSelectGarantByLoc extends Requete<Garant>{

	@Override
	public String requete() {
		return "SELECT g.* "
				+ "FROM MSF5131A.SAE_Garant g "
				+ "JOIN MSF5131A.SAE_Locataire l "
				+ "  ON l.fk_Id_Garant = g.Id_Garant "
				+ "WHERE l.Id_Locataire = ? ";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
