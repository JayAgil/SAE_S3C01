package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import modele.BienLouable;
import modele.Diagnostics;

public class DaoDiagnostics extends DaoModele<Diagnostics> implements Dao<Diagnostics> {

	public DaoDiagnostics() throws SQLException {
		super();
	}

	/** Ajoute un diagnostic dans la base de données. */
	@Override
	public int create(Diagnostics t) throws SQLException {
		return miseAJour(new RequeteInsertDiagnostics(), t);
	}

	/** Met à jour un diagnostic existant dans la base de données. */
	@Override
	public int update(Diagnostics t) throws SQLException {
		return miseAJour(new RequeteUpdateDiagnostics(), t);
	}

	/** Supprime un diagnostic de la base de données. */
	@Override
	public int delete(Diagnostics t) throws SQLException {
		return this.miseAJour(new RequeteDeleteDiagnostics(), t);
	}

	/** Cherche un diagnostic par son identifiant unique. */
	@Override
	public Diagnostics findById(String... id) throws SQLException {
		return findById(new RequeteSelectDiagnostics(), id);
	}

	/** Récupère tous les diagnostics de la base de données. */
	@Override
	public List<Diagnostics> findAll() throws SQLException {
		List<Diagnostics> result = find(new RequeteSelectDiagnostics());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Cherche tous les diagnostics associés à un bien louable spécifique.
	 *
	 * @param idBien identifiant du bien louable
	 * @return liste de diagnostics associés au bien
	 * @throws SQLException
	 */
	public List<Diagnostics> findDiagnosticsByIdBien(String idBien) throws SQLException {
		List<Diagnostics> result = this.find(new RequeteSelectDiagnosticFromBien(), idBien);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance de Diagnostics à partir d'un ResultSet.
	 *
	 * @param rs le curseur du résultat de la requête
	 * @return une instance de Diagnostics
	 * @throws SQLException
	 */
	@Override
	protected Diagnostics creerInstance(ResultSet rs) throws SQLException {
		DaoBienLouable dBL = new DaoBienLouable();
		String idDiagnostics = rs.getString(1);
		String typeDiagnostics = rs.getString(2);
		Date dateRealisation = rs.getDate(3);
		Date dateValidite = rs.getDate(4);
		String fichier = rs.getString(5);
		BienLouable bienLouable = dBL.findById(rs.getString(6));
		return new Diagnostics(idDiagnostics, typeDiagnostics, dateRealisation, dateValidite, fichier, bienLouable);
	}

}
