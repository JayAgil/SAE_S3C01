package modele.dao.requetes;

public class RequeteDeleteLocataire extends RequeteSelectLocataireById{

	@Override
	public String requete() {
		return "DELETE FROM Locataire where idlocataire = ? ";
	}
}
