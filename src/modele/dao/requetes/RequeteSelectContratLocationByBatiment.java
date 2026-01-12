package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer les contrats de location associés à un
 * bâtiment spécifique.
 */
public class RequeteSelectContratLocationByBatiment extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer tous les contrats de location dont le
	 * bien louable appartient au bâtiment spécifié.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return "SELECT c.* " + "FROM SAE_ContratLocation c "
				+ "JOIN SAE_BienLouable b ON c.fk_Id_BienLouable = b.Id_BienLouable " + "WHERE b.fk_Adresse_Bat = ?";

	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'adresse du bâtiment.
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
