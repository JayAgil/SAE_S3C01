package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.Batiment;

public class RequeteSelectBatimentById extends Requete<Batiment> {
	public String requete() {
		return " Select * from Batiment where adresse = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, Assurance donnee) {
		
	}

}
