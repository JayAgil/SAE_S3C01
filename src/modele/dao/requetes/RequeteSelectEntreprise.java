package modele.dao.requetes;

import modele.Entreprise;

public class RequeteSelectEntreprise extends Requete<Entreprise>{
	
	/**
	 * Retourne la requête SQL.
	 * Sélectionne toutes les entreprises.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Entreprise ";
	}

}
