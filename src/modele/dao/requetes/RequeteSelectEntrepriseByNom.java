package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

public class RequeteSelectEntrepriseByNom extends Requete<Entreprise> {

	/**
	 * Retourne la requête SQL. Sélectionne une entreprise par son nom.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Entreprise where Nom = ?";
	}

	/**
	 * Renseigne le paramètre de la requête.
	 * 
	 * @param id nom de l'entreprise
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
