package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Paiement;

public class RequeteSelectPaiementById extends Requete<Paiement> {

	/**
	 * Retourne la requête SQL pour sélectionner un paiement par son identifiant.
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_PAIEMENT where id_paiement = ?";
	}

	/**
	 * Définit les paramètres de la requête préparée. Ici, on remplace le premier
	 * paramètre par l'identifiant du paiement.
	 *
	 * @param prSt PreparedStatement à paramétrer
	 * @param id   Tableau contenant l'identifiant du paiement
	 * @throws SQLException en cas d'erreur SQL
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
