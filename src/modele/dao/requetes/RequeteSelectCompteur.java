package modele.dao.requetes;

import modele.Compteur;

/**
 * Requête permettant de récupérer tous les compteurs de la base de données. Les
 * résultats sont triés par l'index nouveau dans l'ordre décroissant.
 */
public class RequeteSelectCompteur extends Requete<Compteur> {

	/**
	 * Fournit la requête SQL pour récupérer tous les compteurs.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_Compteur Order by Index_nouveau DESC";
	}
}
