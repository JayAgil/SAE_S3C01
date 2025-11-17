package modele.dao.requetes;

import modele.BienLouable;

public class RequeteSelectBienLouable extends Requete<BienLouable> {
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from BienLouable ";
	}

}
