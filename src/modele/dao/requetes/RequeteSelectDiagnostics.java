package modele.dao.requetes;

import modele.Diagnostics;

public class RequeteSelectDiagnostics extends Requete<Diagnostics> {

	/**
	 * Retourne la requête SQL. Sélectionne l’ensemble des diagnostics.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Diagnostics ";
	}

}
