package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

/**
 * Requête permettant de récupérer tous les biens louables d'un bâtiment
 * spécifique. La recherche se fait à partir de l'adresse du bâtiment.
 */
public class RequeteSelectBienLouableByBat extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL pour récupérer les biens louables d'un bâtiment donné.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " SELECT * " + "FROM MSF5131A.SAE_BienLouable " + "WHERE fk_Adresse_Bat = ? ";

	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'adresse du bâtiment.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   tableau contenant l'adresse du bâtiment en première position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}