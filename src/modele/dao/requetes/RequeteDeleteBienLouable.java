package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.BienLouable;

public class RequeteDeleteBienLouable extends Requete<BienLouable>{
	public String requete() {
		return " Delete from BienLouable where id_bienLouable = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, Assurance donnee) {
		
	}
}
