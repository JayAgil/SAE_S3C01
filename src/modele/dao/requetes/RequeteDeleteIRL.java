package modele.dao.requetes;

public class RequeteDeleteIRL extends RequeteSelectIRLById{
	@Override
	public String requete() {
		return "DELETE FROM IRL where annee = ?";
	}
}
