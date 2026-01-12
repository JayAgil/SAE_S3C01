package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.BienLouable;

/**
 * Requête permettant de supprimer un bien louable de la base de données. La
 * suppression est réalisée à partir de l'identifiant du bien louable.
 */
public class RequeteDeleteBienLouable extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL de suppression d'un bien louable.
	 *
	 * @return la requête SQL DELETE
	 */
	public String requete() {
		return "Delete from MSF5131A.SAE_BienLouable where Id_BienLouable = ? ";

	}

	/**
	 * Renseigne les paramètres de la requête SQL. L'identifiant du bien louable est
	 * utilisé pour déterminer quel bien doit être supprimé.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param bl   le bien louable à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement prSt, BienLouable bl) throws SQLException {
		prSt.setString(1, bl.getIdBienLouable());
	}

}
