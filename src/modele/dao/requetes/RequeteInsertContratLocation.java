package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant d'insérer un contrat de location dans la table
 * SAE_ContratLocation.
 */
public class RequeteInsertContratLocation extends Requete<ContratLocation> {

	/**
	 * Fournit la requête SQL d'insertion pour la table SAE_ContratLocation.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_ContratLocation VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations du contrat
	 * de location.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param c  le contrat de location à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, ContratLocation c) throws SQLException {
		ps.setString(1, c.getNumeroDeContrat());

		if (c.getDateDebut() != null)
			ps.setDate(2, c.getDateDebut());
		else
			ps.setNull(2, java.sql.Types.DATE);

		if (c.getDateFin() != null)
			ps.setDate(3, c.getDateFin());
		else
			ps.setNull(3, java.sql.Types.DATE);

		ps.setDouble(4, c.getMontantDeCaution());
		ps.setDouble(5, c.getProvisionCharge());
		ps.setDouble(6, c.getSolde());
		ps.setDouble(7, c.getMontantMensuel());

		if (c.getDateVersement() != null)
			ps.setDate(8, c.getDateVersement());
		else
			ps.setNull(8, java.sql.Types.DATE);

		ps.setDouble(9, c.getIndexCompteurEau());
		ps.setDouble(10, c.getIndexCompteurElectricite());
		ps.setDouble(11, c.getIndexCompteurGaz());
		ps.setString(12, c.getBienLouable().getIdBienLouable());
	}

}
