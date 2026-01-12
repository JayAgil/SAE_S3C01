package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.BienLouable;
import modele.ChargesGenerales;

public class DaoChargesGenerales extends DaoModele<ChargesGenerales> implements Dao<ChargesGenerales> {

	public DaoChargesGenerales() throws SQLException {
		super();
	}

	/** Ajoute une charge générale dans la base de données. */
	@Override
	public int create(ChargesGenerales t) throws SQLException {
		return miseAJour(new RequeteInsertChargeGenerale(), t);
	}

	/** Met à jour une charge générale existante dans la base de données. */
	@Override
	public int update(ChargesGenerales t) throws SQLException {
		return miseAJour(new RequeteUpdateChargesGenerales(), t);
	}

	/** Supprime une charge générale de la base de données. */
	@Override
	public int delete(ChargesGenerales t) throws SQLException {
		return miseAJour(new RequeteDeleteChargesGenerales(), t);
	}

	/** Cherche une charge générale par son identifiant unique. */
	@Override
	public ChargesGenerales findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectChargesGeneralesById(), id);
	}

	/** Récupère toutes les charges associées à un bâtiment spécifique. */
	public List<ChargesGenerales> findByIdBatiment(String... id) throws SQLException {
		List<ChargesGenerales> result = this.find(new RequeteSelectChargesByBatiment(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/** Récupère toutes les charges associées à un bien louable spécifique. */
	public List<ChargesGenerales> findByIdBien(String... id) throws SQLException {
		List<ChargesGenerales> result = this.find(new RequeteSelectChargesByBien(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/** Récupère toutes les charges générales de la base de données. */
	@Override
	public List<ChargesGenerales> findAll() throws SQLException {
		List<ChargesGenerales> result = this.find(new RequeteSelectChargesGenerales());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance de ChargesGenerales à partir d'un ResultSet.
	 * 
	 * @param curseur le curseur du résultat de la requête
	 * @return une instance de ChargesGenerales
	 * @throws SQLException
	 */
	@Override
	protected ChargesGenerales creerInstance(ResultSet curseur) throws SQLException {
		String id_ChargesGenerale = curseur.getString(1);
		String type = curseur.getString(2);
		double montant = curseur.getDouble(3);
		float pourcentage = curseur.getFloat(4);
		double quotite = curseur.getDouble(5);
		Date dateCharge = curseur.getDate(6);
		String id = curseur.getString(7);
		DaoBienLouable daoBL = new DaoBienLouable();
		BienLouable bl = daoBL.findById(id);

		return new ChargesGenerales(id_ChargesGenerale, type, montant, pourcentage, quotite, dateCharge, bl);
	}
}
