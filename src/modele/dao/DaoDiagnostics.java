package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;


import modele.BienLouable;
import modele.Diagnostics;

public class DaoDiagnostics extends DaoModele<Diagnostics> implements Dao<Diagnostics> {

	public DaoDiagnostics() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Diagnostics t) throws SQLException {
		return miseAJour(new RequeteInsertDiagnostics(), t);	
	}
	
	@Override
	public int update(Diagnostics t) throws SQLException {
		return miseAJour(new RequeteUpdateDiagnostics(), t);
	}

	@Override
	public int delete(Diagnostics t) throws SQLException {
		return this.miseAJour(new RequeteDeleteDiagnostics(), t);

	}

	@Override
	public Diagnostics findById(String... id) throws SQLException {
		return findById(new RequeteSelectDiagnostics(), id);
	}

	@Override
	public List<Diagnostics> findAll() throws SQLException {
		return find(new RequeteSelectDiagnostics());
	}
	
	public List<Diagnostics> findDiagnosticsByIdBien(String idBien) throws SQLException {
	    return this.find(new RequeteSelectDiagnosticFromBien(), idBien);
	}

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
