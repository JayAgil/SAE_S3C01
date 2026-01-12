package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Compteur;

/**
 * Requête permettant de supprimer un compteur de la base de données. La
 * suppression est effectuée à partir de l'identifiant du compteur.
 */
public class RequeteDeleteCompteur extends Requete<Compteur> {

	/**
	 * Fournit la requête SQL de suppression du compteur.
	 *
	 * @return la requête SQL DELETE
	 */
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Compteur WHERE Id_Compteur = ?";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. L'identifiant du compteur est
	 * utilisé pour déterminer quel compteur doit être supprimé.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param cpt  le compteur à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, Compteur cpt) throws SQLException {
		prSt.setString(1, cpt.getIdCompteur());
	}
}
