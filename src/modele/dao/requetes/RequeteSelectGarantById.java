package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

public class RequeteSelectGarantById extends Requete<Garant>{
	
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Garant where Id_Garant = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
