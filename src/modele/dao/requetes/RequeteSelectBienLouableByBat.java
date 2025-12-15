package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienLouableByBat extends Requete<BienLouable> {
	
	public String requete() {
		return " SELECT * "
				+ "FROM MSF5131A.SAE_BienLouable "
				+ "WHERE fk_Adresse_Bat = ? ";
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
