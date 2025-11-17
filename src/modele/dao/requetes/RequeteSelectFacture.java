package modele.dao.requetes;

import modele.Facture;

public class RequeteSelectFacture extends Requete<Facture>{

	@Override
	public String requete() {
		return "Select * from Facture";
	}

}
