package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.Batiment;
import modele.BienLouable;
import modele.dao.requetes.*;

public class DaoBienLouable extends DaoModele<BienLouable> implements Dao<BienLouable> {

	public DaoBienLouable() throws SQLException {
		super();
	}

	/** Ajoute un bien louable dans la base de données. */
	@Override
	public int create(BienLouable t) throws SQLException {
		return miseAJour(new RequeteInsertBienLouable(), t);
	}

	/** Met à jour un bien louable existant dans la base de données. */
	@Override
	public int update(BienLouable t) throws SQLException {
		return miseAJour(new RequeteUpdateBienLouable(), t);
	}

	/** Supprime un bien louable de la base de données. */
	@Override
	public int delete(BienLouable t) throws SQLException {
		return miseAJour(new RequeteDeleteBienLouable(), t);
	}

	/** Cherche un bien louable par son identifiant unique. */
	@Override
	public BienLouable findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectBienLouableById(), id);
	}

	/** Cherche un bien louable associé à un contrat spécifique. */
	public BienLouable findByIdContrat(String... id) throws SQLException {
		return this.findById(new RequeteSelectBienFromContrat(), id);
	}

	/** Récupère tous les biens louables de la base de données. */
	@Override
	public List<BienLouable> findAll() throws SQLException {
		List<BienLouable> result = this.find(new RequeteSelectBienLouable());
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	/** Récupère les biens louables d’un bâtiment donné. */
	public List<BienLouable> findByBatiment(String... id) throws SQLException {
		List<BienLouable> result = this.find(new RequeteSelectBienLouableByBat(), id);
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	/**
	 * Même méthode que findByBatiment, récupère les biens par l'identifiant du
	 * bâtiment.
	 */
	public List<BienLouable> findByIdBat(String... id) throws SQLException {
		List<BienLouable> result = this.find(new RequeteSelectBienLouableByBat(), id);
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	/** Récupère un bien louable à partir de l'identifiant du locataire. */
	public BienLouable findByIdLoc(String... id) throws SQLException {
		return this.findById(new RequeteSelectBienLouableByIdLoc(), id);
	}

	/** Récupère un bien louable à partir de l'identifiant d'une charge. */
	public BienLouable findByIdCharge(String... id) throws SQLException {
		return this.findById(new RequeteSelectBienByIdCharge(), id);
	}

	/** Récupère un bien louable à partir de l'identifiant d'un compteur. */
	public BienLouable findByIdCompteur(String... id) throws SQLException {
		return this.findById(new RequeteSelectBienFromCompteur(), id);
	}

	/**
	 * Crée une instance de BienLouable à partir d'un ResultSet.
	 * 
	 * @param curseur le curseur du résultat de la requête
	 * @return une instance de BienLouable
	 * @throws SQLException
	 */
	@Override
	protected BienLouable creerInstance(ResultSet curseur) throws SQLException {
		String idBienLouable = curseur.getString(1);
		String numFiscale = curseur.getString(2);
		String adresse = curseur.getString(3);
		double surface = curseur.getDouble(4);
		int nbPieces = curseur.getInt(5);
		String typeBienLouable = curseur.getString(6);
		String idBien2 = curseur.getString(7);
		String idBatiment = curseur.getString(8);

		Batiment batiment = null;
		if (idBatiment != null && !idBatiment.isEmpty()) {
			DaoBatiment daoBat = new DaoBatiment();
			batiment = daoBat.findById(idBatiment);
		}

		BienLouable bien2 = null;
		if (idBien2 != null && !idBien2.isEmpty()) {
			DaoBienLouable daoBl = new DaoBienLouable();
			bien2 = daoBl.findById(idBien2);
		}

		return new BienLouable(idBienLouable, numFiscale, adresse, surface, nbPieces, typeBienLouable, batiment, bien2);
	}
}
