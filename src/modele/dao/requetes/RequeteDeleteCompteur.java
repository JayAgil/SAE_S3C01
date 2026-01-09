package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.Compteur;

public class RequeteDeleteCompteur extends Requete<Compteur>{
	public String requete() {
		return " Select * from MSF5131A.SAE_Compteur where Id_Compteur = ? " ;
	}

	public void parametres(PreparedStatement prSt, Compteur cpt) throws SQLException {
		prSt.setString(1, cpt.getIdCompteur());
	}

	public void parametres(PreparedStatement prSt, Assurance donnee) {
		
	}
}
