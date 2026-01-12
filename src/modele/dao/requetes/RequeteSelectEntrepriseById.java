package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

public class RequeteSelectEntrepriseById extends Requete<Entreprise> {

	/**
	 * Retourne la requête SQL.
	 * Sélectionne une entreprise par son identifiant.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Entreprise where Numero_Siret = ?";
	}
	
	/**
	 * Renseigne le paramètre de la requête.
	 * @param id numéro SIRET de l'entreprise
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
