package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.IRL;

/**
 * Requête permettant d'insérer un IRL (Indice de Référence des Loyers) dans la
 * base de données.
 */
public class RequeteInsertIRL extends Requete<IRL> {

	/**
	 * Fournit la requête SQL d'insertion d'un IRL.
	 *
	 * @return la requête SQL INSERT
	 */
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_IRL (Annee, IRL, Trimestre) VALUES (?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations de l'IRL.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param i  l'IRL à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement ps, IRL i) throws SQLException {
		ps.setLong(1, i.getAnnee());
		ps.setDouble(2, i.getIRL());
		ps.setInt(3, i.getTrimestre());
	}

}
