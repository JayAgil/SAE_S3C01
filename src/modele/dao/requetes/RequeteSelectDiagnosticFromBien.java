package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteSelectDiagnosticFromBien extends Requete<Diagnostics> {

	/**
	 * Retourne la requête SQL. Sélectionne tous les diagnostics liés à un bien
	 * louable grâce à la clé étrangère fk_Id_BienLouable.
	 */
	@Override
	public String requete() {
		return "SELECT * " + "FROM MSF5131A.SAE_Diagnostics " + "WHERE fk_Id_BienLouable = ? ";
	}

	/**
	 * Associe le paramètre de la requête SQL.
	 * 
	 * @param prSt PreparedStatement à paramétrer
	 * @param id   identifiant du bien louable
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
