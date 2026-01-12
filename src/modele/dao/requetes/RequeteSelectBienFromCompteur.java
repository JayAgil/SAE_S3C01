package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

/**
 * Requête permettant de récupérer un bien louable associé à un compteur
 * spécifique.
 */
public class RequeteSelectBienFromCompteur extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL pour récupérer le bien louable correspondant à un
	 * compteur donné.
	 *
	 * @return la requête SQL SELECT avec jointure sur la table des compteurs
	 */
	@Override
	public String requete() {
		return "SELECT bl.* " + "FROM MSF5131A.SAE_BienLouable bl " + "JOIN MSF5131A.SAE_Compteur c "
				+ "  ON c.fk_Id_BienLouable = bl.Id_BienLouable " + "WHERE c.Id_Compteur = ?";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant du compteur.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   l'identifiant du compteur (id[0])
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
