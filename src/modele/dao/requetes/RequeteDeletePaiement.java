package modele.dao.requetes;

public class RequeteDeletePaiement extends RequeteSelectPaiementById{
	@Override
	public String requete() {
		return "DELETE FROM Paiement where Id_Paiement = ? ";
	}
	
}
