package modele.dao.requetes;

public class RequeteDeleteGarant extends RequeteSelectGarantById{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Garant where Id_Garant = ? ";
	}
}
