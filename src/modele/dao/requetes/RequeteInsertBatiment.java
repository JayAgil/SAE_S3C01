package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

/**
 * Requête permettant d'insérer un bâtiment dans la base de données. Tous les
 * champs du bâtiment sont insérés.
 */
public class RequeteInsertBatiment extends Requete<Batiment> {

	/**
	 * Fournit la requête SQL d'insertion pour la table SAE_Batiment.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_Batiment VALUES (?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les données du bâtiment.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param a  le bâtiment à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Batiment a) throws SQLException {
		ps.setString(1, a.getAdresse());
		ps.setDate(2, a.getDateConstruction());

	}

}
