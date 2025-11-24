package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.IRL;

public class DaoIRL extends DaoModele<IRL> implements Dao<IRL> {

	@Override
	public void create(IRL t) {
		DaoTest.insertIRL(t);
	}

	@Override
	public void update(IRL t) {
		DaoTest.updateIRL(t);

	}

	@Override
	public int delete(IRL t) throws SQLException {
		return this.miseAJour(new RequeteDeleteIRL(), t);
	}

	@Override
	public IRL findById(String... id) throws SQLException {
		return findById(new RequeteSelectIRL(), id);
	}

	@Override
	public List<IRL> findAll() throws SQLException {
		return find(new RequeteSelectIRL());
	}

	@Override
	protected IRL creerInstance(ResultSet rs) throws SQLException {
		return new IRL(rs.getDouble(1), rs.getInt(2));
	}

}
