package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Entreprise;

/**
 * Requête permettant de supprimer une entreprise de la base de données. La
 * suppression est effectuée à partir du numéro SIRET de l'entreprise.
 */
public class RequeteDeleteEntreprise extends Requete<Entreprise> {

	/**
	 * Fournit la requête SQL permettant de supprimer une entreprise.
	 *
	 * @return la requête SQL DELETE
	 */
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Entreprise where Numero_Siret = ?";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. Le numéro SIRET est utilisé pour
	 * identifier l'entreprise à supprimer.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param e  l'entreprise à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Entreprise e) throws SQLException {
		ps.setString(1, e.getNumSiret());

	}
}
