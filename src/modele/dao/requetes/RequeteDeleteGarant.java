package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;
import modele.Garant;

public class RequeteDeleteGarant extends Requete<Garant>{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Garant where Id_Garant = ? ";
	}
	
	@Override
	public void parametres(PreparedStatement ps, Garant g) throws SQLException {
		ps.setString(1, g.getIdGarant());

	}
}
