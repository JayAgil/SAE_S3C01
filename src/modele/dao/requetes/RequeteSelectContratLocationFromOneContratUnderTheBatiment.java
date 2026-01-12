package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer tous les contrats de location se trouvant
 * dans le même bâtiment qu'un contrat donné, triés par date de début
 * décroissante.
 */
public class RequeteSelectContratLocationFromOneContratUnderTheBatiment extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour récupérer tous les contrats dans le même bâtiment
	 * qu'un contrat spécifique.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return "SELECT c2.* " + "FROM MSF5131A.SAE_ContratLocation c1 "
				+ "JOIN MSF5131A.SAE_BienLouable b1 ON c1.fk_Id_BienLouable = b1.Id_BienLouable "
				+ "JOIN MSF5131A.SAE_BienLouable b2 ON b2.fk_Adresse_Bat = b1.fk_Adresse_Bat "
				+ "JOIN MSF5131A.SAE_ContratLocation c2 ON c2.fk_Id_BienLouable = b2.Id_BienLouable "
				+ "WHERE c1.Numero_de_contrat = ? " + "Order by c2.Date_debut DESC";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec le numéro du contrat de
	 * référence.
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
