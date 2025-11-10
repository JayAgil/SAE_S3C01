package modele.dao;

import java.util.List;

import modele.Garant;

public class DaoGarant implements Dao<Garant> {

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
	public Garant findById(String... id) {
		if (DaoTest.selectGarant(id).size()==0) {
			return null;
		}
		return DaoTest.selectGarant(id).get(0);
	}

	@Override
	public List<Garant> findAll() {
		return DaoTest.selectGarant();
	}

}
