package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteSelectDiagnosticsById extends Requete<Diagnostics>{

	@Override
	public String requete() {
		return "Select * from Diagnostics where id_diagnostics = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}



}
