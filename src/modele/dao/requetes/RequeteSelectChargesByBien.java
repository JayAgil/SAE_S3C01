package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

/**
 * Requête permettant de récupérer toutes les charges générales associées à un
 * bien louable à partir de l'identifiant du bien.
 */
public class RequeteSelectChargesByBien extends Requete<ChargesGenerales> {

	/**
	 * Fournit la requête SQL pour récupérer les charges générales d'un bien
	 * louable.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return "SELECT * " + "FROM MSF5131A.SAE_Charges_Generale " + "WHERE fk_Id_BienLouable = ? "
				+ "Order by Date_Charge";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant du bien
	 * louable.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   tableau contenant l'identifiant du bien louable en première
	 *             position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
