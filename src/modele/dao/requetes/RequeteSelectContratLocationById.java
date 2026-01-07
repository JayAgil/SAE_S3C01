package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ContratLocation;

public class RequeteSelectContratLocationById extends Requete<ContratLocation> {
	public String requete() {
		return " Select * from MSF5131A.SAE_ContratLocation where numero_De_Contrat = ? Order by Date_debut DESC" ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, ContratLocation donnee) {
		
	}

}
