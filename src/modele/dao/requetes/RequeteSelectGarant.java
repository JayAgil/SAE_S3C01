package modele.dao.requetes;

import modele.Garant;

public class RequeteSelectGarant extends Requete<Garant>{

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Garant";
	}

}
