package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteSelectDiagnosticsById extends Requete<Diagnostics> {

	/**
	 * Retourne la requête SQL. Sélectionne un diagnostic selon son identifiant.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Diagnostics where Id_Diagnostics = ?";
	}

	/**
	 * Définit le paramètre de la requête.
	 * 
	 * @param prSt PreparedStatement utilisé pour la requête
	 * @param id   identifiant du diagnostic
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
