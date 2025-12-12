package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

public class RequeteSelectChargesByBatiment extends Requete<ChargesGenerales>{

	@Override
	public String requete() {
		return "SELECT cg.* "
				+ "FROM MSF5131A.SAE_Charges_Generale cg "
				+ "JOIN MSF5131A.SAE_BienLouable bl ON cg.fk_Id_BienLouable = bl.Id_BienLouable "
				+ "WHERE bl.fk_Adresse_Bat = ? "
				+ "";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
