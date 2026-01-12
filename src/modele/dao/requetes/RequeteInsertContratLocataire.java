package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Requête permettant d'insérer un lien entre un locataire et un contrat dans la
 * table SAE_Contrat_Locataire.
 */
public class RequeteInsertContratLocataire extends Requete<Void> {

	/**
	 * Fournit la requête SQL d'insertion pour la table SAE_Contrat_Locataire.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat) VALUES (?, ?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant du locataire et
	 * le numéro du contrat.
	 *
	 * @param ps            le PreparedStatement à compléter
	 * @param idLocataire   l'identifiant du locataire
	 * @param numeroContrat le numéro du contrat
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement ps, String idLocataire, String numeroContrat) throws SQLException {
		ps.setString(1, idLocataire);
		ps.setString(2, numeroContrat);
	}
}
