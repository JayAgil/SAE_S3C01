package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Garant;

/**
 * Requête permettant de supprimer un garant de la base de données. La
 * suppression est réalisée à partir de l'identifiant du garant.
 */
public class RequeteDeleteGarant extends Requete<Garant> {

	/**
	 * Fournit la requête SQL permettant de supprimer un garant.
	 *
	 * @return la requête SQL DELETE
	 */
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Garant where Id_Garant = ? ";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. L'identifiant du garant est
	 * utilisé pour identifier le garant à supprimer.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param g  le garant à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Garant g) throws SQLException {
		ps.setString(1, g.getIdGarant());

	}
}
