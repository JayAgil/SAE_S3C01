package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteDeleteDiagnostics extends Requete<Diagnostics> {

	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Diagnostics where Id_Diagnostics = ?";
	}

	@Override
	public void parametres(PreparedStatement ps, Diagnostics d) throws SQLException {
		ps.setString(1, d.getIdDiagnostics());

	}
}
