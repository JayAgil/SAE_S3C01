package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteDeleteAssurance extends Requete<Assurance>{
	
	public String requete() {
		return " Delete from Assurance where numeroAssurance = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, Assurance donnee) {
		
	}

}
