package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

/**
 * Requête permettant de récupérer toutes les charges générales associées à un
 * bâtiment à partir de l'adresse du bâtiment.
 */
public class RequeteSelectChargesByBatiment extends Requete<ChargesGenerales> {

	/**
	 * Fournit la requête SQL pour récupérer les charges générales d'un bâtiment.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return "SELECT cg.* " + "FROM MSF5131A.SAE_Charges_Generale cg "
				+ "JOIN MSF5131A.SAE_BienLouable bl ON cg.fk_Id_BienLouable = bl.Id_BienLouable "
				+ "WHERE bl.fk_Adresse_Bat = ? " + "Order by Date_Charge";
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
