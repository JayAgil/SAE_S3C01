package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

public class RequeteSelectBatimentByBien extends Requete<Batiment> {
	public String requete() {
		return "SELECT b.Adresse, b.Date_construction "
			     + "FROM MSF5131A.SAE_Batiment b "
			     + "JOIN MSF5131A.SAE_BienLouable bl ON bl.fk_Adresse_Bat = b.Adresse "
			     + "WHERE bl.Id_BienLouable = ?";

	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}



}
