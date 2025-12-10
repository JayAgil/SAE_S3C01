package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.IRL;

public class RequeteSelectIRLById extends Requete<IRL>{

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_IRL where annee = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
