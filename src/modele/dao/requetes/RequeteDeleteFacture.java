package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Facture;

/**
 * Requête permettant de supprimer une facture de la base de données. La
 * suppression est réalisée à partir du numéro de facture.
 */
public class RequeteDeleteFacture extends Requete<Facture> {

	/**
	 * Fournit la requête SQL permettant de supprimer une facture.
	 *
	 * @return la requête SQL DELETE
	 */
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Facture where Numero_Facture = ?";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. Le numéro de facture est utilisé
	 * pour identifier la facture à supprimer.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param f  la facture à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Facture f) throws SQLException {
		ps.setString(1, f.getNumeroFacture());

	}
}
