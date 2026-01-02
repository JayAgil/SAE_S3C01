package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

public class RequeteSelectEntrepriseByNom extends Requete<Entreprise> {

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Entreprise where Nom = ?";
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
