package modele.dao.requetes;

import modele.Facture;

public class RequeteSelectFacture extends Requete<Facture>{
	
	/**
	 * Retourne la requête SQL.
	 * Sélectionne toutes les factures.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Facture ";
	}
	
	

}
