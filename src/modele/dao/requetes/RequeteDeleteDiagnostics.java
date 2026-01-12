package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

/**
 * Requête permettant de supprimer un diagnostic de la base de données. La
 * suppression est réalisée à partir de l'identifiant du diagnostic.
 */
public class RequeteDeleteDiagnostics extends Requete<Diagnostics> {

	/**
	 * Fournit la requête SQL permettant de supprimer un diagnostic.
	 *
	 * @return la requête SQL DELETE
	 */
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Diagnostics where Id_Diagnostics = ?";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. L'identifiant du diagnostic est
	 * utilisé pour déterminer quel diagnostic doit être supprimé.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param d  le diagnostic à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Diagnostics d) throws SQLException {
		ps.setString(1, d.getIdDiagnostics());

	}
}
