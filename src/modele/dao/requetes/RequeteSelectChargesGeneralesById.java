package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.ChargesGenerales;

public class RequeteSelectChargesGeneralesById extends Requete<ChargesGenerales>{

	public String requete() {
		return " Select * from ChargesGenerales where id_ChargesGenerale = ? " ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, Assurance donnee) {
		
	}
}
