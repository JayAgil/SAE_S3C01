package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteSelectContratLocationByLoc extends Requete<ContratLocation> {
	public String requete() {
		return "SELECT c.* FROM MSF5131A.SAE_ContratLocation c JOIN MSF5131A.SAE_Contrat_Locataire cl ON c.Numero_de_contrat = cl.Numero_de_contrat WHERE cl.Id_Locataire = ? Order by Date_debut DESC";

	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
