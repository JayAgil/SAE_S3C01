package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;
import modele.Locataire;

public class RequeteDeleteLocataire extends Requete<Locataire>{

	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_LOCATAIRE where Id_Locataire = ? ";
	}
	
	@Override
	public void parametres(PreparedStatement ps, Locataire l) throws SQLException {
		ps.setString(1, l.getIdLocataire());

	}
}
