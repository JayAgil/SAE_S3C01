package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de supprimer un contrat de location de la base de données.
 * La suppression est effectuée à partir du numéro du contrat.
 */
public class RequeteDeleteContratLocation extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL de suppression du contrat de location.
	 *
	 * @return la requête SQL DELETE
	 */
	public String requete() {
		return " Delete from MSF5131A.SAE_ContratLocation where Numero_de_contrat = ? ";
	}

	/**
	 * Renseigne les paramètres de la requête SQL. Le numéro du contrat est utilisé
	 * pour déterminer quel contrat doit être supprimé.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param cl   le contrat de location à supprimer
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement prSt, ContratLocation cl) throws SQLException {
		prSt.setString(1, cl.getNumeroDeContrat());
	}
}
