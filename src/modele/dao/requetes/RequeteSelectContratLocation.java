package modele.dao.requetes;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer tous les contrats de location. Les résultats
 * sont triés par date de début décroissante.
 */
public class RequeteSelectContratLocation extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer tous les contrats de location triés par
	 * date de début décroissante.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_ContratLocation Order by Date_debut DESC";
	}

}
