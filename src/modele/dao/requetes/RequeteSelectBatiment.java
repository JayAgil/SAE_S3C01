package modele.dao.requetes;

import modele.Batiment;

/**
 * Requête permettant de récupérer tous les bâtiments de la base de données.
 */
public class RequeteSelectBatiment extends Requete<Batiment> {

	/**
	 * Fournit la requête SQL pour récupérer tous les bâtiments.
	 *
	 * @return la requête SQL SELECT pour tous les bâtiments
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_Batiment ";
	}

}
