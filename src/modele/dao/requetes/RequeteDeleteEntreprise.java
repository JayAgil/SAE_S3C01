package modele.dao.requetes;

public class RequeteDeleteEntreprise extends RequeteSelectEntrepriseById{

	@Override
	public String requete() {
		return "DELETE FROM Entreprise where numero_siret = ?";
	}
}
