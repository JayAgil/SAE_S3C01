package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import modele.dao.requetes.*;
import modele.BienLouable;
import modele.Entreprise;
import modele.Facture;

public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	public DaoFacture() throws SQLException {
		super();
	}

	/** Ajoute une facture dans la base de données. */
	@Override
	public int create(Facture t) throws SQLException {
		return miseAJour(new RequeteInsertFacture(), t);
	}

	/** Met à jour une facture existante dans la base de données. */
	@Override
	public int update(Facture t) throws SQLException {
		return miseAJour(new RequeteUpdateFacture(), t);
	}

	/** Supprime une facture de la base de données. */
	@Override
	public int delete(Facture t) throws SQLException {
		return this.miseAJour(new RequeteDeleteFacture(), t);
	}

	/** Cherche une facture par son identifiant unique (numéro de facture). */
	@Override
	public Facture findById(String... id) throws SQLException {
		return findById(new RequeteSelectFactureById(), id);
	}

	/** Récupère toutes les factures de la base de données. */
	@Override
	public List<Facture> findAll() throws SQLException {
		return find(new RequeteSelectFacture());
	}

	/**
	 * Cherche la date de la dernière facture pour un bien donné.
	 *
	 * @param idBien identifiant du bien louable
	 * @return la facture correspondant à la date la plus récente pour ce bien
	 * @throws SQLException
	 */
	public Facture findDateDernierTravauxByBien(String idBien) throws SQLException {
		return this.findById(new RequeteSelectDateFactureByBien(), idBien);
	}

	/**
	 * Récupère toutes les factures d'un bien louable.
	 *
	 * @param idBien identifiant du bien louable
	 * @return liste de factures associées au bien
	 * @throws SQLException
	 */
	public List<Facture> findFactureByBienLouable(String idBien) throws SQLException {
		List<Facture> result = this.find(new RequeteSelectFactureByBien(), idBien);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance de Facture à partir d'un ResultSet. Récupère les objets
	 * BienLouable et Entreprise liés via leurs DAOs respectifs.
	 *
	 * @param rs le curseur du résultat de la requête
	 * @return une instance de Facture
	 * @throws SQLException
	 */
	@Override
	protected Facture creerInstance(ResultSet rs) throws SQLException {

		DaoBienLouable dBL = new DaoBienLouable();
		DaoEntreprise dE = new DaoEntreprise();
		String numeroFacture = rs.getString(1);
		double montant = rs.getDouble(2);
		Date dateDeFacture = rs.getDate(3);
		String compteBancaire = rs.getString(4);
		double montantDevis = rs.getDouble(5);
		Date datePaiement = rs.getDate(6);
		String designationDeTravaux = rs.getString(7);
		BienLouable bienLouable = dBL.findById(rs.getString(8));
		Entreprise entreprise = dE.findById(rs.getString(9));

		return new Facture(numeroFacture, montant, dateDeFacture, compteBancaire, montantDevis, datePaiement,
				designationDeTravaux, bienLouable, entreprise);
	}
}
