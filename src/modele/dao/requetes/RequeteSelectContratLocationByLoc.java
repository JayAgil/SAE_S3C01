package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer tous les contrats de location d'un locataire
 * spécifique, triés par date de début décroissante.
 */
public class RequeteSelectContratLocationByLoc extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer les contrats d'un locataire à partir de
	 * son identifiant.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return "SELECT c.* FROM MSF5131A.SAE_ContratLocation c JOIN MSF5131A.SAE_Contrat_Locataire cl ON c.Numero_de_contrat = cl.Numero_de_contrat WHERE cl.Id_Locataire = ? Order by Date_debut DESC";

	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant du locataire.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant l'identifiant du locataire en première
	 *             position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
