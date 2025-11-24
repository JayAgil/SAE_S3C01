package modele.dao.requetes;

public class RequeteDeleteGarant extends RequeteSelectGarantById{
	@Override
	public String requete() {
		return "DELETE FROM Garant where id_garant = ? ";
	}
}
