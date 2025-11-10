package modele.dao;

import java.util.List;

import modele.ChargesGenerales;

public class DaoChargesGenerales implements Dao<ChargesGenerales> {

	@Override
	public void create(ChargesGenerales t) {
		DaoTest.insertChargesGenerales(t);
		
	}

	@Override
	public void update(ChargesGenerales t) {
		DaoTest.updateChargesGenerales(t);
		
	}

	@Override
	public void delete(ChargesGenerales t) {
		DaoTest.deleteChargesGenerales(t);
		
	}

	@Override
	public ChargesGenerales findById(String... id) {
		if (DaoTest.selectChargesGenerales(id).size()==0) {
			return null;
		}
		return DaoTest.selectChargesGenerales(id).get(0);
	}

	@Override
	public List<ChargesGenerales> findAll() {
		return DaoTest.selectChargesGenerales();
	}

}
