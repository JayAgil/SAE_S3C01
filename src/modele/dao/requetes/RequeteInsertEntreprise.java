package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

/**
 * Requête permettant d'insérer une entreprise dans la base de données.
 */
public class RequeteInsertEntreprise extends Requete<Entreprise> {

	/**
	 * Fournit la requête SQL d'insertion d'une entreprise.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Entreprise VALUES (?,?,?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations de
	 * l'entreprise.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param e  l'entreprise à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Entreprise e) throws SQLException {
		ps.setString(1, e.getNumSiret());
		ps.setString(2, e.getAdresse());
		ps.setString(3, e.getVille());
		ps.setString(4, e.getCodePostal());
		ps.setString(5, e.getNom());
		ps.setString(6, e.getNumTel());
		ps.setString(7, e.getSpecialite());
	}

}
