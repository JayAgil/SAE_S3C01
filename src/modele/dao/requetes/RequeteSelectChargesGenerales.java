package modele.dao.requetes;

import modele.ChargesGenerales;

public class RequeteSelectChargesGenerales extends Requete<ChargesGenerales>{

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_Charges_Generale " ;
	}

}
