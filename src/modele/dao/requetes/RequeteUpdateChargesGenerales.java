package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

public class RequeteUpdateChargesGenerales extends Requete<ChargesGenerales> {

	/**
	 * Retourne la requête SQL pour mettre à jour une charge générale. Les champs
	 * mis à jour sont : type de charge, montant total, pourcentage, quotité et date
	 * de la charge.
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "UPDATE MSF5131A.SAE_Charges_Generale " + "SET Type_Charge = ?, " + "Montant_Total = ?, "
				+ "Pourcentage = ?, " + "Quotite = ?, " + "Date_Charge = ? " + "WHERE Id_Charges_Generale = ?";
	}

	/**
	 * Paramètre le PreparedStatement avec les valeurs de l'objet ChargesGenerales
	 * fourni. L'ordre des paramètres doit correspondre exactement à celui de la
	 * requête SQL.
	 *
	 * @param prSt   PreparedStatement à paramétrer
	 * @param donnee ChargesGenerales contenant les nouvelles valeurs
	 * @throws SQLException en cas d'erreur SQL
	 */
	@Override
	public void parametres(PreparedStatement prSt, ChargesGenerales donnee) throws SQLException {
		prSt.setString(1, donnee.getTypeCharge());
		prSt.setDouble(2, donnee.getMontant());
		prSt.setFloat(3, donnee.getPourcentage());
		prSt.setDouble(4, donnee.getQuotite());
		prSt.setDate(5, donnee.getDateCharge());
		prSt.setString(6, donnee.getIdChargesGenerales());
	}

}
