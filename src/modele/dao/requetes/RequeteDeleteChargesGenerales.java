package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ChargesGenerales;

/**
 * Requête permettant de supprimer des charges générales de la base de données.
 * La suppression est effectuée à partir de l'identifiant des charges.
 */
public class RequeteDeleteChargesGenerales extends Requete<ChargesGenerales> {

	/**
	 * Fournit la requête SQL de suppression des charges générales.
	 *
	 * @return la requête SQL DELETE
	 */
	public String requete() {
		return " Delete from MSF5131A.SAE_Charges_Generale where Id_Charges_Generale = ? ";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. L'identifiant des charges
	 * générales est utilisé pour déterminer quelles charges doivent être
	 * supprimées.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param cg   les charges générales à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement prSt, ChargesGenerales cg) throws SQLException {
		prSt.setString(1, cg.getIdChargesGenerales());
	}

}
