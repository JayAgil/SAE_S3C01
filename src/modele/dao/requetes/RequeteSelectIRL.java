package modele.dao.requetes;

import modele.IRL;

public class RequeteSelectIRL extends Requete<IRL>{

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_IRL";
	}

}
