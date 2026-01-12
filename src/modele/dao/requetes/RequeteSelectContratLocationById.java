package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ContratLocation;

/**
 * Requête permettant de récupérer un contrat de location spécifique à partir de
 * son numéro de contrat, trié par date de début décroissante.
 */
public class RequeteSelectContratLocationById extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer un contrat de location par son numéro.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_ContratLocation where numero_De_Contrat = ?";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec le numéro du contrat.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant le numéro du contrat en première position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
