package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

/**
 * Requête permettant de récupérer un bien louable associé à une charge générale
 * donnée.
 */
public class RequeteSelectBienByIdCharge extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL pour récupérer le bien louable correspondant à une
	 * charge générale spécifique.
	 *
	 * @return la requête SQL SELECT avec jointure sur les charges générales
	 */
	@Override
	public String requete() {
		return "SELECT bl.* " + "FROM MSF5131A.SAE_BienLouable bl " + "JOIN MSF5131A.SAE_Charges_Generale cg "
				+ "    ON cg.fk_Id_BienLouable = bl.Id_BienLouable " + "WHERE cg.Id_Charges_Generale = ?";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant des charges
	 * générales.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   l'identifiant des charges générales (id[0])
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
