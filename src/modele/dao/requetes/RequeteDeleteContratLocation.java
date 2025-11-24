package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.ContratLocation;

public class RequeteDeleteContratLocation extends Requete<ContratLocation> {
	public String requete() {
		return " Delete from ContratLocation where numero_De_Contrat = ? " ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, ContratLocation donnee) {
		
	}
}
