package modele.dao.requetes;

public class RequeteDeleteFacture extends RequeteSelectFactureById {
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Facture where Numero_Facture = ?";
	}
}
