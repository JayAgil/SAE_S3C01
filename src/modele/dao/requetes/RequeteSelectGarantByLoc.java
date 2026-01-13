package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

public class RequeteSelectGarantByLoc extends Requete<Garant> {

	/**
	 * Requête permettant de récupérer le garant associé à un locataire spécifique.
	 * On effectue une jointure entre la table des garants et la table des
	 * locataires en utilisant la clé étrangère fk_Id_Garant pour trouver le garant
	 * correspondant.
	 * 
	 * La requête sélectionne toutes les colonnes de la table des garants pour le
	 * locataire donné.
	 */
	@Override
	public String requete() {
		return "SELECT g.* " + "FROM MSF5131A.SAE_Garant g " + "JOIN MSF5131A.SAE_Locataire l "
				+ "  ON l.fk_Id_Garant = g.Id_Garant " + "WHERE l.Id_Locataire = ? ";
	}

	/**
	 * Méthode pour définir les paramètres de la requête préparée.
	 * 
	 * @param prSt L'objet PreparedStatement à paramétrer
	 * @param id   Tableau contenant l'identifiant du locataire pour lequel on
	 *             recherche le garant
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
