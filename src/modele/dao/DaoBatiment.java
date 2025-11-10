package modele.dao;

import java.util.List;

import modele.Batiment;

public class DaoBatiment implements Dao<Batiment> {

	@Override
	public void create(Batiment t) {
		DaoTest.insertBatiment(t);
		
	}

	@Override
	public void update(Batiment t) {
		DaoTest.updateBatiment(t);
	}

	@Override
	public void delete(Batiment t) {
		DaoTest.deleteBatiment(t);
		
	}

	@Override
	public Batiment findById(String... id) {
		if (DaoTest.selectBatiment(id).size()==0) {
			return null;
		}
		return DaoTest.selectBatiment(id).get(0);
	}

	@Override
	public List<Batiment> findAll() {
		return DaoTest.selectBatiment();
	}

}
