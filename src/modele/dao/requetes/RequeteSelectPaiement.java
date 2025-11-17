package modele.dao.requetes;

import modele.Paiement;

public class RequeteSelectPaiement extends Requete<Paiement> {

	@Override
	public String requete() {
		return "Select * from Paiement";
	}
	
	

}
