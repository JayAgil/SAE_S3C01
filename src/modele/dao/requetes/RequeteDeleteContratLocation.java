package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteDeleteContratLocation extends Requete<ContratLocation> {
	public String requete() {
		return " Delete from MSF5131A.SAE_ContratLocation where Numero_de_contrat = ? " ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, ContratLocation donnee) {
		
	}
}
