package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

/**
 * Requête permettant d'insérer une assurance dans la base de données. Tous les
 * champs de l'assurance sont insérés.
 */
public class RequeteInsertAssurance extends Requete<Assurance> {

	/**
	 * Retourne la requête SQL d'insertion pour la table {@code SAE_ASSURANCE}.
	 * 
	 * @return la requête SQL INSERT avec 8 paramètres
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_ASSURANCE VALUES (?,?,?, ?, ?, ?, ?, ?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les données de l'assurance.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param a  l'objet Assurance à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Assurance a) throws SQLException {
		ps.setString(1, a.getNumeroAssurance());
		ps.setDouble(2, a.getPrime());
		ps.setDouble(3, a.getMontant());
		ps.setString(4, a.getTypeAssurance());
		ps.setString(5, a.getAgence());
		ps.setString(6, a.getAdresseAgence());
		ps.setString(7, a.getTelAgence());
		ps.setString(8, a.getBatiment().getAdresse());
	}

}
