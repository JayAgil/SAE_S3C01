package modele.dao.requetes;

public class RequeteDeleteFacture extends RequeteSelectFactureById {
	@Override
	public String requete() {
		return "DELETE FROM Facture where numeroFacture = ?";
	}
}
