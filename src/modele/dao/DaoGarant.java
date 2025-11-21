package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Garant;

public class DaoGarant extends DaoModele<Garant> implements Dao<Garant> {

	@Override
	public void create(Garant t) {
		DaoTest.insertGarant(t);

	}

	@Override
	public void update(Garant t) {
		DaoTest.updateGarant(t);

	}

	@Override
	public void delete(Garant t) {
		DaoTest.deleteGarant(t);

	}

	@Override
	public Garant findById(String... id) throws SQLException {
		return findById(new RequeteSelectGarantById(), id);
	}

	@Override
	public List<Garant> findAll() throws SQLException {
		return find(new RequeteSelectGarantById());
	}

	@Override
	protected Garant creerInstance(ResultSet rs) throws SQLException {
		String idGarant = rs.getString(1);
		String nom = rs.getString(2);
		String adresse = rs.getString(3);
		String tel = rs.getString(4);
		return new Garant(idGarant, nom, adresse, tel);
	}

}
