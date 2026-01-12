package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

/**
 * Requête permettant de sélectionner toutes les assurances liées à un bâtiment
 * spécifique.
 */
public class RequeteSelectAssuranceByBatiment extends Requete<Assurance> {

	/**
	 * Fournit la requête SQL pour récupérer les assurances associées à un bâtiment
	 * donné.
	 *
	 * @return la requête SQL SELECT avec condition sur l'adresse du bâtiment
	 */
	@Override
	public String requete() {
		return "SELECT * " + "FROM MSF5131A.SAE_ASSURANCE " + "WHERE fk_Adresse = ?";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'adresse du bâtiment.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant l'adresse du bâtiment à utiliser pour
	 *             filtrer les assurances
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
