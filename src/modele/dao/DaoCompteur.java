package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.BienLouable;
import modele.Compteur;

public class DaoCompteur extends DaoModele<Compteur> implements Dao<Compteur> {

	public DaoCompteur() throws SQLException {
		super();
	}

	/** Ajoute un compteur dans la base de données. */
	@Override
	public int create(Compteur t) throws SQLException {
		return miseAJour(new RequeteInsertCompteur(), t);
	}

	/** Met à jour un compteur existant dans la base de données. */
	@Override
	public int update(Compteur t) throws SQLException {
		return miseAJour(new RequeteUpdateCompteur(), t);
	}

	/** Supprime un compteur de la base de données. */
	@Override
	public int delete(Compteur t) throws SQLException {
		return miseAJour(new RequeteDeleteCompteur(), t);
	}

	/** Cherche un compteur par son identifiant unique. */
	@Override
	public Compteur findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectCompteurById(), id);
	}

	/** Récupère tous les compteurs associés à un bâtiment spécifique. */
	public List<Compteur> findByIdBatiment(String... id) throws SQLException {
		List<Compteur> result = this.find(new RequeteSelectCompteurByBatiment(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/** Récupère tous les compteurs associés à un bien louable spécifique. */
	public List<Compteur> findByIdBien(String... id) throws SQLException {
		List<Compteur> result = this.find(new RequeteSelectCompteurByBien(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/** Récupère tous les compteurs de la base de données. */
	@Override
	public List<Compteur> findAll() throws SQLException {
		List<Compteur> result = this.find(new RequeteSelectCompteur());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance de Compteur à partir d'un ResultSet.
	 * 
	 * @param curseur le curseur du résultat de la requête
	 * @return une instance de Compteur
	 * @throws SQLException
	 */
	@Override
	protected Compteur creerInstance(ResultSet curseur) throws SQLException {
		String id_Compteur = curseur.getString(1);
		double partie_fixe = curseur.getDouble(2);
		double partie_variable = curseur.getDouble(3);
		double total = curseur.getDouble(4);
		String type = curseur.getString(5);
		Date d = curseur.getDate(6);
		double index_ancien = curseur.getDouble(7);
		double index_nouveau = curseur.getDouble(8);
		String id = curseur.getString(9);
		DaoBienLouable daoBL = new DaoBienLouable();
		BienLouable bl = daoBL.findById(id);

		return new Compteur(id_Compteur, partie_fixe, partie_variable, total, d, bl, index_ancien, index_nouveau, type);
	}

}
