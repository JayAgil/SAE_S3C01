package modele.dao.requetes;

public class RequeteDeleteIRL extends RequeteSelectIRLById{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_IRL where Annee = ?";
	}
}
