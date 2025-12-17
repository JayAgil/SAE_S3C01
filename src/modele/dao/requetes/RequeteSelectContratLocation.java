package modele.dao.requetes;
import modele.ContratLocation;

public class RequeteSelectContratLocation extends Requete<ContratLocation> {
	
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_CONTRATLOCATION " ;
	}

}
