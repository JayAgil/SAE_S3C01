package modele.dao.requetes;

import modele.Locataire;

public class RequeteSelectLocataire extends Requete<Locataire> {

	/**
	 * Retourne la requête SQL pour sélectionner tous les locataires.
	 * 
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_LOCATAIRE ";
	}

}
