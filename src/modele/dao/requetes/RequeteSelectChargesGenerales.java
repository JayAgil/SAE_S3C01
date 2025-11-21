package modele.dao.requetes;

import modele.ChargesGenerales;

public class RequeteSelectChargesGenerales extends Requete<ChargesGenerales>{

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from ChargesGenerales " ;
	}

}
