package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ChargesGenerales;

public class RequeteDeleteChargesGenerales extends Requete<ChargesGenerales>{
	
	public String requete() {
		return " Delete from MSF5131A.SAE_Charges_Generale where Id_Charges_Generale = ? " ;
	}

	public void parametres(PreparedStatement prSt, ChargesGenerales cg) throws SQLException {
		prSt.setString(1, cg.getIdChargesGenerales());
	}


}
