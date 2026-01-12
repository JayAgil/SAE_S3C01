package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import modele.Garant;

public class DaoGarant extends DaoModele<Garant> implements Dao<Garant> {

	public DaoGarant() throws SQLException {
		super();
	}

	/** Ajoute un garant dans la base de données. */
	@Override
	public int create(Garant t) throws SQLException {
		return miseAJour(new RequeteInsertGarant(), t);
	}

	/** Met à jour un garant existant dans la base de données. */
	@Override
	public int update(Garant t) throws SQLException {
		return miseAJour(new RequeteUpdateGarant(), t);
	}

	/** Supprime un garant de la base de données. */
	@Override
	public int delete(Garant t) throws SQLException {
		return this.miseAJour(new RequeteDeleteGarant(), t);
	}

	/** Cherche un garant par son identifiant unique. */
	@Override
	public Garant findById(String... id) throws SQLException {
		return findById(new RequeteSelectGarantById(), id);
	}

	/** Récupère tous les garants de la base de données. */
	@Override
	public List<Garant> findAll() throws SQLException {
		List<Garant> result = find(new RequeteSelectGarantById());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Cherche un garant associé à un locataire spécifique.
	 *
	 * @param id identifiant du locataire
	 * @return le garant associé au locataire
	 * @throws SQLException
	 */
	public Garant findByLoc(String... id) throws SQLException {
		return this.findById(new RequeteSelectGarantByLoc(), id);
	}

	/**
	 * Crée une instance de Garant à partir d'un ResultSet.
	 *
	 * @param rs le curseur du résultat de la requête
	 * @return une instance de Garant
	 * @throws SQLException
	 */
	@Override
	protected Garant creerInstance(ResultSet rs) throws SQLException {
		String idGarant = rs.getString(1);
		String nom = rs.getString(2);
		String prenom = rs.getString(3);
		String adresse = rs.getString(4);
		String tel = rs.getString(5);
		
		return new Garant(idGarant, nom, prenom, adresse, tel);
	}
}
