package modele.dao.requetes;

import modele.IRL;

public class RequeteSelectIRL extends Requete<IRL> {

	/**
	 * Retourne la requête SQL pour sélectionner toutes les entrées de la table IRL.
	 * 
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_IRL ";
	}

}
