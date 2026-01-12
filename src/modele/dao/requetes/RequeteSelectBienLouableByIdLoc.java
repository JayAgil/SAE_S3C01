package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

/**
 * Requête permettant de récupérer tous les biens louables associés à un
 * locataire à partir de l'identifiant du locataire.
 */
public class RequeteSelectBienLouableByIdLoc extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL pour récupérer les biens louables d'un locataire.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return """
				SELECT *
				FROM MSF5131A.SAE_BienLouable bl
				JOIN MSF5131A.SAE_ContratLocation cl
				    ON bl.Id_BienLouable = cl.fk_Id_BienLouable
				JOIN MSF5131A.SAE_Contrat_Locataire cll
				    ON cl.Numero_de_contrat = cll.Numero_de_contrat
				WHERE cll.Id_Locataire = ?
				""";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant du locataire.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   tableau contenant l'identifiant du locataire en première position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
