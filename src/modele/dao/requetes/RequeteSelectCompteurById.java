package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.Compteur;

public class RequeteSelectCompteurById extends Requete<Compteur> {
	public String requete() {
		return "Select * from MSF5131A.SAE_Compteur where Id_Compteur = ? Order by Index_nouveau DESC" ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, Assurance donnee) {
		
	}
}
