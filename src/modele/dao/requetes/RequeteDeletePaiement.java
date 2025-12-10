package modele.dao.requetes;

public class RequeteDeletePaiement extends RequeteSelectPaiementById{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_PAIEMENT where Id_Paiement = ? ";
	}
	
}
