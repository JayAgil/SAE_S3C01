package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.IRL;

public class RequeteSelectIRLById extends Requete<IRL> {

	/**
	 * Retourne la requête SQL pour sélectionner une entrée IRL correspondant à une
	 * année et un trimestre donnés.
	 * 
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "SELECT * FROM MSF5131A.SAE_IRL WHERE annee = ? AND trimestre = ?";
	}

	/**
	 * Initialise les paramètres de la requête préparée avec l'année et le
	 * trimestre.
	 * 
	 * @param prSt PreparedStatement à paramétrer
	 * @param keys Tableau contenant les clés [annee, trimestre] sous forme de
	 *             String
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement prSt, String... keys) throws SQLException {
		prSt.setInt(1, Integer.parseInt(keys[0]));
		prSt.setInt(2, Integer.parseInt(keys[1]));
	}
}
