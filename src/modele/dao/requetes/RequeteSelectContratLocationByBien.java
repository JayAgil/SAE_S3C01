package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer le dernier contrat de location associé à un
 * bien louable spécifique.
 */
public class RequeteSelectContratLocationByBien extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer le dernier contrat d'un bien louable
	 * donné, trié par date de début décroissante.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_ContratLocation where fk_Id_BienLouable = ? Order by Date_debut DESC FETCH FIRST 1 ROWS ONLY";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant du bien louable.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant l'identifiant du bien louable en première
	 *             position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
