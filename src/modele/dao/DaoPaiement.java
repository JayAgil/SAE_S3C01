package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.ContratLocation;
import modele.Paiement;
import modele.dao.requetes.*;

public class DaoPaiement extends DaoModele<Paiement> implements Dao<Paiement> {

	public DaoPaiement() throws SQLException {
		super();
	}

	/**
	 * Crée un paiement dans la base.
	 * 
	 * @param t Paiement à insérer
	 * @return nombre de lignes affectées
	 * @throws SQLException si une erreur SQL survient
	 */
	public int create(Paiement t) throws SQLException {
		return miseAJour(new RequeteInsertPaiement(), t);
	}

	/**
	 * Met à jour un paiement existant.
	 * 
	 * @param t Paiement à mettre à jour
	 * @return nombre de lignes affectées
	 * @throws SQLException si une erreur SQL survient
	 */
	public int update(Paiement t) throws SQLException {
		return miseAJour(new RequeteUpdatePaiement(), t);
	}

	/**
	 * Supprime un paiement.
	 * 
	 * @param t Paiement à supprimer
	 * @return nombre de lignes affectées
	 * @throws SQLException si une erreur SQL survient
	 */
	public int delete(Paiement t) throws SQLException {
		return this.miseAJour(new RequeteDeletePaiement(), t);
	}

	/**
	 * Recherche un paiement par son identifiant.
	 * 
	 * @param id identifiant du paiement
	 * @return le Paiement trouvé ou null
	 * @throws SQLException si une erreur SQL survient
	 */
	public Paiement findById(String... id) throws SQLException {
		return findById(new RequeteSelectPaiement(), id);
	}

	/**
	 * Retourne tous les paiements de la base.
	 * 
	 * @return liste des paiements, ou liste vide si aucun
	 * @throws SQLException si une erreur SQL survient
	 */
	public List<Paiement> findAll() throws SQLException {
		List<Paiement> result = find(new RequeteSelectPaiement());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Trouve le dernier paiement pour un contrat de location donné.
	 * 
	 * @param idCL identifiant du ContratLocation
	 * @return dernier Paiement pour ce contrat, ou null
	 * @throws SQLException si une erreur SQL survient
	 */
	public Paiement findDateDernierPaiementByCL(String idCL) throws SQLException {
		return this.findById(new RequeteSelectDatePaiementByCL(), idCL);
	}

	/**
	 * Retourne la liste des paiements effectués par un locataire.
	 * 
	 * @param idLoc identifiant du locataire
	 * @return liste de paiements ou liste vide si aucun
	 * @throws SQLException si une erreur SQL survient
	 */
	public List<Paiement> findPaiementsByLocataire(String idLoc) throws SQLException {
		List<Paiement> result = this.find(new RequeteSelectPaiementsByLoc(), idLoc);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance de Paiement à partir d'un ResultSet.
	 * 
	 * @param rs ResultSet provenant de la requête
	 * @return instance de Paiement
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	protected Paiement creerInstance(ResultSet rs) throws SQLException {
		DaoContratLocation dCL = new DaoContratLocation();
		String idpaiement = rs.getString(1);
		Double montant = rs.getDouble(2);
		Date datePaiement = rs.getDate(3);
		ContratLocation cl = dCL.findById(rs.getString(4));
		String designation = rs.getString(5);
		return new Paiement(idpaiement, montant, datePaiement, designation, cl);
	}
}
