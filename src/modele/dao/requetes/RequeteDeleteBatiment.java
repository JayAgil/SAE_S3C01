package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Batiment;

/**
 * Requête permettant de supprimer un bâtiment de la base de données. La
 * suppression est effectuée à partir de l'adresse du bâtiment.
 */
public class RequeteDeleteBatiment extends Requete<Batiment> {

	/**
	 * Retourne la requête SQL permettant de supprimer un bâtiment.
	 *
	 * @return la requête SQL DELETE
	 */
	public String requete() {
		return " Delete from MSF5131A.SAE_Batiment where adresse = ? ";

	}

	/**
	 * Affecte les paramètres de la requête SQL. L'adresse du bâtiment est utilisée
	 * pour identifier le bâtiment à supprimer.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param b    le bâtiment à supprimer
	 * @throws SQLException si une erreur survient lors du paramétrage
	 */
	public void parametres(PreparedStatement prSt, Batiment b) throws SQLException {
		prSt.setString(1, b.getAdresse());
	}

}
