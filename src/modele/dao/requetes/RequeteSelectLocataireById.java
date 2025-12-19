package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectLocataireById extends Requete<Locataire> {
	
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Locataire where id_locataire = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
