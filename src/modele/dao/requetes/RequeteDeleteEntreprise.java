package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;
import modele.Entreprise;

public class RequeteDeleteEntreprise extends Requete<Entreprise>{

	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Entreprise where Numero_Siret = ?";
	}
	
	@Override
	public void parametres(PreparedStatement ps, Entreprise e) throws SQLException {
		ps.setString(1, e.getNumSiret());

	}
}
