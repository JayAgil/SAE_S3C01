package modele.dao.requetes;

import modele.Garant;

public class RequeteSelectGarant extends Requete<Garant> {

	/**
	 * Requête permettant de récupérer tous les garants de la base de données.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Garant";
	}

}
