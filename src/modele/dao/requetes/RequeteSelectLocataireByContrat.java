package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;
import modele.Locataire;

public class RequeteSelectLocataireByContrat extends Requete<Locataire> {
	
	public String requete() {
		return " Select * from MSF5131A.SAE_CONTRAT_LOCATAIRE where NUMERO_DE_CONTRAT = ? ";
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, Locataire donnee) {
		
	}

}
