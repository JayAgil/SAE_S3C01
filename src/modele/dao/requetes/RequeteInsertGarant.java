package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

/**
 * Requête permettant d'insérer un garant dans la base de données.
 */
public class RequeteInsertGarant extends Requete<Garant> {

	/**
	 * Fournit la requête SQL d'insertion d'un garant.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Garant VALUES (?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations du garant.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param g  le garant à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Garant g) throws SQLException {
		ps.setString(1, g.getIdGarant());
		ps.setString(2, g.getNom());
		ps.setString(3, g.getPrenom());
		ps.setString(4, g.getAdresse());
		ps.setString(5, g.getTel());
	}

}
