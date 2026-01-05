package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

public class RequeteSelectBatimentByAssurance extends Requete<Batiment>{
	public String requete() {
		return " SELECT b.* "
				+ "FROM MSF5131A.SAE_Batiment b "
				+ "JOIN MSF5131A.SAE_Assurance a "
				+ "ON a.fk_Adresse = b.Adresse "
				+ "WHERE a.Numero_d_assurance = ? ";
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
