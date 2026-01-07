package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteSelectContratFromBienAndLoc extends Requete<ContratLocation>{

	public String requete() {
		return "SELECT cl.* "
				+ "FROM MSF5131A.SAE_ContratLocation cl "
				+ "JOIN MSF5131A.SAE_Contrat_Locataire cll "
				+ "ON cll.Numero_de_contrat = cl.Numero_de_contrat "
				+ "WHERE cll.Id_Locataire = ? "
				+ "AND cl.fk_Id_BienLouable = ? "
				+ "Order by Date_debut DESC";
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
	}

}
