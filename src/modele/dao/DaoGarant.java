package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Garant;

public class DaoGarant extends DaoModele<Garant> implements Dao<Garant> {

	public DaoGarant() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Garant t) throws SQLException {
		return miseAJour(new RequeteInsertGarant(), t);	
	}
	
	@Override
	public int update(Garant t) throws SQLException {
		return miseAJour(new RequeteUpdateGarant(), t);
	}

	@Override
	public int delete(Garant t) throws SQLException {
		return this.miseAJour(new RequeteDeleteGarant(), t);
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
		String prenom = rs.getString(3);
		String adresse = rs.getString(4);
		String tel = rs.getString(5);
		return new Garant(idGarant, nom, prenom, adresse, tel);
	}

}
