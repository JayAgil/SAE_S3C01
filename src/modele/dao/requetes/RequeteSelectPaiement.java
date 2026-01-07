package modele.dao.requetes;

import modele.Paiement;

public class RequeteSelectPaiement extends Requete<Paiement> {

	@Override
	public String requete() {
		return """
			    SELECT *
			    FROM MSF5131A.SAE_PAIEMENT
			    ORDER BY Date_Paiement DESC
			""";
	}
	

}
