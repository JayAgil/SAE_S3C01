package modele.dao.requetes;

import modele.Assurance;

/**
 * Requête permettant de sélectionner toutes les assurances de la base de
 * données.
 */
public class RequeteSelectAssurance extends Requete<Assurance> {

	/**
	 * Fournit la requête SQL pour récupérer toutes les assurances.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "Select * from MSF5131A.SAE_ASSURANCE";
	}

}
