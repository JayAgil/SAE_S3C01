package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Batiment;

public class DaoBatiment extends DaoModele<Batiment> implements Dao<Batiment> {

	@Override
	public void create(Batiment t) {
		DaoTest.insertBatiment(t);
		
	}

	@Override
	public void update(Batiment t) throws SQLException {
		miseAJour(new RequeteUpdateBatiment(), t);
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

	@Override
	protected Batiment creerInstance(ResultSet curseur) throws SQLException {
		String adresse = curseur.getString(1);
		Date dateConstruction = curseur.getDate(2);
		return new Batiment(adresse,dateConstruction);
	}

}
