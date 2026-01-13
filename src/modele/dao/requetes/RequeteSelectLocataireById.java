package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectLocataireById extends Requete<Locataire> {
	
	/**
     * Retourne la requête SQL pour sélectionner un locataire selon son identifiant.
     * @return String contenant la requête SQL
     */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Locataire where id_locataire = ?";
	}
	
	/**
     * Définit le paramètre de la requête (identifiant du locataire).
     * @param prSt PreparedStatement à paramétrer
     * @param id Tableau contenant l'identifiant du locataire (id[0])
     * @throws SQLException
     */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
