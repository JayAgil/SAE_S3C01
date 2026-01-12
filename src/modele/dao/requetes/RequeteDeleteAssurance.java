package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

/**
 * Requête permettant de supprimer une assurance de la base de données. La
 * suppression est effectuée à partir du numéro d’assurance.
 */
public class RequeteDeleteAssurance extends Requete<Assurance> {

	/**
	 * Retourne la requête SQL permettant de supprimer une assurance.
	 *
	 * @return la requête SQL DELETE
	 */
	public String requete() {
		return " Delete from MSF5131A.SAE_Assurance where Numero_d_assurance = ? ";

	}

	/**
	 * Affecte les paramètres de la requête SQL. Le numéro d'assurance est utilisé
	 * pour identifier l'assurance à supprimer.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param a    l'assurance à supprimer
	 * @throws SQLException si une erreur survient lors de l'affectation des
	 *                      paramètres
	 */
	public void parametres(PreparedStatement prSt, Assurance a) throws SQLException {
		prSt.setString(1, a.getNumeroAssurance());
	}

}
