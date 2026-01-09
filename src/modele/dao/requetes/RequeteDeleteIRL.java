package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;
import modele.IRL;

public class RequeteDeleteIRL extends RequeteSelectIRLById{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_IRL where Annee = ?";
	}
	
	@Override
	public void parametres(PreparedStatement ps, IRL irl) throws SQLException {
		ps.setDouble(1, irl.getAnnee());

	}
}
