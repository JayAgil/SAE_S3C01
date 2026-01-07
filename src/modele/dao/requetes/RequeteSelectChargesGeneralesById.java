package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ChargesGenerales;

public class RequeteSelectChargesGeneralesById extends Requete<ChargesGenerales>{

	public String requete() {
		return " Select * from MSF5131A.SAE_Charges_Generale where Id_Charges_Generale = ? Order by Date_Charge" ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
