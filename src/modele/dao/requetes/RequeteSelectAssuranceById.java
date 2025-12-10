package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteSelectAssuranceById extends Requete<Assurance> {
	public String requete() {
		return " Select * from MSF5131A.SAE_ASSURANCE where Numero_d_assurance = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
