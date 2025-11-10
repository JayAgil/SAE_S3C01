package modele.dao;

import java.util.List;

import modele.ContratLocation;

public class DaoContratLocation implements Dao<ContratLocation> {

	@Override
	public void create(ContratLocation t) {
		DaoTest.insertContratLocation(t);
		
	}

	@Override
	public void update(ContratLocation t) {
		DaoTest.updateContratLocation(t);
		
	}

	@Override
	public void delete(ContratLocation t) {
		DaoTest.deleteContratLocation(t);
		
	}

	@Override
	public ContratLocation findById(String... id) {
		if (DaoTest.selectContratLocation(id).size()==0) {
			return null;
		}
		return DaoTest.selectContratLocation(id).get(0);
	}

	@Override
	public List<ContratLocation> findAll() {
		return DaoTest.selectContratLocation();
	}

}
