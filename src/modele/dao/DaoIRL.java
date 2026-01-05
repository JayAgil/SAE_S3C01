package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.IRL;

public class DaoIRL extends DaoModele<IRL> implements Dao<IRL> {

	public DaoIRL() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(IRL t) throws SQLException {
		return this.miseAJour(new RequeteInsertIRL(), t);
	}

	@Override
	public int delete(IRL t) throws SQLException {
		return 0;
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
		return new IRL(rs.getInt(1),rs.getDouble(2));
	}

	@Override
	public int update(IRL t) throws SQLException {
		return 0;
	}

}
