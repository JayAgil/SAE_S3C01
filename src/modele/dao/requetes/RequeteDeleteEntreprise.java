package modele.dao.requetes;

public class RequeteDeleteEntreprise extends RequeteSelectEntrepriseById{

	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Entreprise where numero_siret = ?";
	}
}
