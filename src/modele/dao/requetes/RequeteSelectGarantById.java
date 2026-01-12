package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

public class RequeteSelectGarantById extends Requete<Garant> {

	/**
	 * Requête permettant de récupérer un garant spécifique à partir de son
	 * identifiant (Id_Garant) dans la base de données.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Garant where Id_Garant = ?";
	}

	/**
	 * Méthode pour définir les paramètres de la requête préparée.
	 * 
	 * @param prSt L'objet PreparedStatement à paramétrer
	 * @param id   Le tableau contenant l'ID du garant à rechercher
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
