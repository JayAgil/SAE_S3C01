package modele.dao.requetes;

import modele.Batiment;

public class RequeteSelectBatiment extends Requete<Batiment> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_Batiment ";
	}
	

}
