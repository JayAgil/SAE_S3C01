package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.Batiment;

public class DaoBatiment extends DaoModele<Batiment> implements Dao<Batiment> {

	public DaoBatiment() throws SQLException {
		super();
	}

	/** Ajoute un bâtiment dans la base de données. */
	@Override
	public int create(Batiment t) throws SQLException {
		return miseAJour(new RequeteInsertBatiment(), t);
	}

	/** Met à jour un bâtiment existant dans la base de données. */
	@Override
	public int update(Batiment t) throws SQLException {
		return miseAJour(new RequeteUpdateBatiment(), t);
	}

	/** Supprime un bâtiment de la base de données. */
	@Override
	public int delete(Batiment t) throws SQLException {
		return miseAJour(new RequeteDeleteBatiment(), t);
	}

	/** Cherche un bâtiment par son adresse (identifiant). */
	@Override
	public Batiment findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectBatimentById(), id);
	}

	/** Récupère tous les bâtiments de la base de données. */
	@Override
	public List<Batiment> findAll() throws SQLException {
		List<Batiment> result = this.find(new RequeteSelectBatiment());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Cherche le bâtiment associé à un bien louable donné.
	 * 
	 * @param id identifiant du bien louable
	 * @return le bâtiment correspondant
	 * @throws SQLException
	 */
	public Batiment findBatimentByBien(String... id) throws SQLException {
		return this.findById(new RequeteSelectBatimentByBien(), id);
	}

	/**
	 * Récupère les bâtiments associés à une assurance donnée.
	 * 
	 * @param id identifiant de l'assurance
	 * @return liste des bâtiments correspondants (vide si aucun)
	 * @throws SQLException
	 */
	public List<Batiment> findBatimentByAssurance(String... id) throws SQLException {
		List<Batiment> result = this.find(new RequeteSelectBatimentByAssurance(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance de Batiment à partir d'un ResultSet.
	 * 
	 * @param curseur le curseur du résultat de la requête
	 * @return une instance de Batiment
	 * @throws SQLException
	 */
	@Override
	protected Batiment creerInstance(ResultSet curseur) throws SQLException {
		String adresse = curseur.getString(1);
		Date dateConstruction = curseur.getDate(2);
		return new Batiment(adresse, dateConstruction);
	}
}
