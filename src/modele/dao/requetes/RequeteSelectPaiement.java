package modele.dao.requetes;

import modele.Paiement;

public class RequeteSelectPaiement extends Requete<Paiement> {

	/**
	 * Retourne la requête SQL pour sélectionner tous les paiements triés par date
	 * de paiement décroissante.
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return """
				    SELECT *
				    FROM MSF5131A.SAE_PAIEMENT
				    ORDER BY Date_Paiement DESC
				""";
	}

}
