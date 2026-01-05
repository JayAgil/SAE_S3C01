package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Batiment;

public class DaoBatiment extends DaoModele<Batiment> implements Dao<Batiment> {

	public DaoBatiment() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Batiment t) throws SQLException {
		return miseAJour(new RequeteInsertBatiment(), t);
		
	}

	@Override
	public int update(Batiment t) throws SQLException {
		return miseAJour(new RequeteUpdateBatiment(), t);
	}

	@Override
	public int delete(Batiment t) throws SQLException {
		return miseAJour(new RequeteDeleteBatiment(), t);
		
	}

	@Override
	public Batiment findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectBatimentById(), id);
	}

	@Override
	public List<Batiment> findAll() throws SQLException {
		return this.find(new RequeteSelectBatiment());
	}
	
	public Batiment findBatimentByBien(String... id) throws SQLException{
		return this.findById(new RequeteSelectBatimentByBien(), id);
	}

	@Override
	protected Batiment creerInstance(ResultSet curseur) throws SQLException {
		String adresse = curseur.getString(1);
		Date dateConstruction = curseur.getDate(2);
		return new Batiment(adresse,dateConstruction);
	}

}
