package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

public class RequeteSelectChargesByBien extends Requete<ChargesGenerales>{
	@Override
	public String requete() {
		return "SELECT * "
				+ "FROM MSF5131A.SAE_Charges_Generale "
				+ "WHERE fk_Id_BienLouable = ? ";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
