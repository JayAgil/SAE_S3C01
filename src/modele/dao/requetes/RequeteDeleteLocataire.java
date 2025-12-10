package modele.dao.requetes;

public class RequeteDeleteLocataire extends RequeteSelectLocataireById{

	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_LOCATAIRE where id_locataire = ? ";
	}
}
