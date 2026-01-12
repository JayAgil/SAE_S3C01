package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Compteur;

/**
 * Requête permettant de récupérer tous les compteurs associés à un bâtiment
 * donné. Les résultats sont triés par l'index nouveau dans l'ordre décroissant.
 */
public class RequeteSelectCompteurByBatiment extends Requete<Compteur> {

	/**
	 * Fournit la requête SQL pour récupérer les compteurs d'un bâtiment spécifique.
	 *
	 * @return la requête SQL SELECT avec jointures
	 */
	@Override
	public String requete() {
		return "SELECT c.* " + "FROM MSF5131A.SAE_Batiment bat "
				+ "JOIN MSF5131A.SAE_BienLouable b ON b.fk_Adresse_Bat = bat.Adresse "
				+ "JOIN MSF5131A.SAE_Compteur c ON c.fk_Id_BienLouable = b.Id_BienLouable " + "WHERE bat.Adresse = ? "
				+ "Order by Index_nouveau DESC";

	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'adresse du bâtiment.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant l'adresse du bâtiment en première position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
