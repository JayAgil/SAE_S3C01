package modele.dao.requetes;

import modele.BienLouable;

/**
 * Requête permettant de récupérer tous les biens louables de la base de données.
 */
public class RequeteSelectBienLouable extends Requete<BienLouable> {
	
	 /**
     * Fournit la requête SQL pour récupérer tous les biens louables.
     *
     * @return la requête SQL SELECT
     */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_BienLouable ";
	}

}
