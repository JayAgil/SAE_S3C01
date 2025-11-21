package modele.dao.requetes;

import modele.Assurance;

public class RequeteSelectAssurance extends Requete<Assurance> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "Select * from assurance" ;
	}

}
