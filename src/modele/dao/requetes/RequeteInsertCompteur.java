package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Compteur;

/**
 * Requête permettant d'insérer un compteur dans la base de données. Tous les
 * champs du compteur sont insérés, y compris le bien louable associé.
 */
public class RequeteInsertCompteur extends Requete<Compteur> {

	/**
	 * Fournit la requête SQL d'insertion pour la table SAE_Compteur.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Compteur VALUES (?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les données du compteur.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param c  le compteur à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Compteur c) throws SQLException {
		ps.setString(1, c.getIdCompteur());
		ps.setDouble(2, c.getPartieFixe());
		ps.setDouble(3, c.getPartieVariable());
		ps.setDouble(4, c.getTotal());
		ps.setString(5, c.getType());
		ps.setDate(6, c.getDateInstallation());
		ps.setDouble(7, c.getIndexAncien());
		ps.setDouble(8, c.getIndexNouveau());
		ps.setString(9, c.getBienLouable().getIdBienLouable());
	}

}
