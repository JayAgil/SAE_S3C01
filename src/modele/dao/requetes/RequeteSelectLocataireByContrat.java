package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectLocataireByContrat extends Requete<Locataire> {

	/**
	 * Retourne la requête SQL pour sélectionner les locataires associés à un
	 * contrat.
	 * 
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "SELECT l.*\r\n" + "FROM MSF5131A.SAE_Locataire l " + "JOIN MSF5131A.SAE_CONTRAT_LOCATAIRE cl "
				+ "    ON l.Id_Locataire = cl.Id_Locataire " + "JOIN MSF5131A.SAE_ContratLocation c "
				+ "    ON cl.Numero_de_contrat = c.Numero_de_contrat " + "WHERE c.Numero_de_contrat = ? "
				+ "ORDER BY c.Date_debut DESC";
	}

	/**
	 * Définit le paramètre de la requête (numéro du contrat).
	 * 
	 * @param prSt PreparedStatement à paramétrer
	 * @param id   Tableau contenant le numéro du contrat (id[0])
	 * @throws SQLException
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire donnee) {

	}

}
