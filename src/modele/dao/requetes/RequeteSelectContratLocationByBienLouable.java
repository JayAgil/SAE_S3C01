package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer tous les contrats de location associés à un
 * bien louable donné, triés par date de début décroissante.
 */
public class RequeteSelectContratLocationByBienLouable extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer les contrats d'un bien louable.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_ContratLocation where FK_ID_BIENLOUABLE = ? Order by Date_debut DESC";
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
