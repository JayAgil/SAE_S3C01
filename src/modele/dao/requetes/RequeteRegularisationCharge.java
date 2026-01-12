package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de calculer la régularisation des charges pour un contrat
 * de location en utilisant la fonction SQL
 * MSF5131A.calcul_regularisation_contrat.
 */
public class RequeteRegularisationCharge extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL pour calculer la régularisation des charges.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return "SELECT  MSF5131A.calcul_regularisation_contrat( ?, ?) AS solde FROM dual";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'année et le numéro du
	 * contrat de location.
	 *
	 * @param ps    le PreparedStatement à compléter
	 * @param c     le contrat de location pour lequel la régularisation est
	 *              calculée
	 * @param annee l'année de calcul de la régularisation
	 * @throws SQLException si une erreur SQL survient
	 */
	public void parametres(PreparedStatement ps, ContratLocation c, int annee) throws SQLException {
		ps.setInt(1, annee);
		ps.setString(2, c.getNumeroDeContrat());
	}

}
