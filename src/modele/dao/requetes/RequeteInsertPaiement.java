package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Paiement;

/**
 * Requête permettant d'insérer un paiement dans la base de données.
 */
public class RequeteInsertPaiement extends Requete<Paiement> {

	/**
	 * Fournit la requête SQL d'insertion d'un paiement.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_PAIEMENT VALUES (?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations du paiement.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param p  le paiement à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Paiement p) throws SQLException {
		ps.setString(1, p.getId_paiement());
		ps.setDouble(2, p.getMontant());
		ps.setDate(3, p.getDatepaiement());
		ps.setString(4, p.getContratLocation().getNumeroDeContrat());
		ps.setString(5, p.getDesignation());
	}
}
