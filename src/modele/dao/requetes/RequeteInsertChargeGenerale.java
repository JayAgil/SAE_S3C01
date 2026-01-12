package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ChargesGenerales;

/**
 * Requête permettant d'insérer une charge générale dans la base de données.
 * Tous les champs de la charge générale sont insérés, y compris le bien louable
 * associé.
 */
public class RequeteInsertChargeGenerale extends Requete<ChargesGenerales> {

	/**
	 * Fournit la requête SQL d'insertion pour la table SAE_Charges_Generale.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Charges_Generale VALUES (?,?,?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les données de la charge
	 * générale.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param cg la charge générale à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, ChargesGenerales cg) throws SQLException {
		ps.setString(1, cg.getIdChargesGenerales());
		ps.setString(2, cg.getTypeCharge());
		ps.setDouble(3, cg.getMontant());
		ps.setDouble(4, cg.getPourcentage());
		ps.setDouble(5, cg.getQuotite());
		ps.setDate(6, cg.getDateCharge());
		ps.setString(7, cg.getBienLouable().getIdBienLouable());
	}

}
