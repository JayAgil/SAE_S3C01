package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.Entreprise;
import modele.dao.requetes.*;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

	public DaoEntreprise() throws SQLException {
		super();
	}

	/** Ajoute une entreprise dans la base de données. */
	@Override
	public int create(Entreprise t) throws SQLException {
		return miseAJour(new RequeteInsertEntreprise(), t);
	}

	/** Met à jour une entreprise existante dans la base de données. */
	@Override
	public int update(Entreprise t) throws SQLException {
		return miseAJour(new RequeteUpdateEntreprise(), t);
	}

	/** Supprime une entreprise de la base de données. */
	@Override
	public int delete(Entreprise t) throws SQLException {
		return this.miseAJour(new RequeteDeleteEntreprise(), t);
	}

	/** Cherche une entreprise par son identifiant unique (numSiret). */
	@Override
	public Entreprise findById(String... id) throws SQLException {
		return findById(new RequeteSelectEntrepriseById(), id);
	}

	/** Récupère toutes les entreprises de la base de données. */
	@Override
	public List<Entreprise> findAll() throws SQLException {
		List<Entreprise> result = find(new RequeteSelectEntreprise());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Cherche une entreprise par son nom.
	 *
	 * @param id tableau contenant le nom de l'entreprise
	 * @return l'entreprise correspondant au nom
	 * @throws SQLException
	 */
	public Entreprise findEntrepriseByNom(String... id) throws SQLException {
		return findById(new RequeteSelectEntrepriseByNom(), id);
	}

	/**
	 * Crée une instance d'Entreprise à partir d'un ResultSet.
	 *
	 * @param rs le curseur du résultat de la requête
	 * @return une instance d'Entreprise
	 * @throws SQLException
	 */
	@Override
	protected Entreprise creerInstance(ResultSet rs) throws SQLException {
		String numSiret = rs.getString(1);
		String adresse = rs.getString(2);
		String ville = rs.getString(3);
		String codePostal = rs.getString(4);
		String nom = rs.getString(5);
		String numTel = rs.getString(6);
		String specialite = rs.getString(7);
		return new Entreprise(numSiret, adresse, ville, codePostal, nom, numTel, specialite);
	}

}
