package modele.dao;

import java.util.List;

import modele.BienLouable;

public class DaoBienLouable implements Dao<BienLouable> {

	@Override
	public void create(BienLouable t) {
		DaoTest.insertBienLouable(t);
		
	}

	@Override
	public void update(BienLouable t) {
		DaoTest.updateBienLouable(t);
		
	}

	@Override
	public void delete(BienLouable t) {
		DaoTest.deleteBienLouable(t);
		
	}

	@Override
	public BienLouable findById(String... id) {
		if (DaoTest.selectBienLouable(id).size()==0) {
			return null;
		}
		return DaoTest.selectBienLouable(id).get(0);
	}

	@Override
	public List<BienLouable> findAll() {
		return DaoTest.selectBienLouable();
	}

}
