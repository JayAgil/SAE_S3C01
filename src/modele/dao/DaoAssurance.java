package modele.dao;

import java.util.List;

import modele.Assurance;

public class DaoAssurance implements Dao<Assurance> {

	@Override
	public void create(Assurance t) {
		DaoTest.insertAssurance(t);
	
	}

	@Override
	public void update(Assurance t) {
		DaoTest.updateAssurance(t);
		
	}

	@Override
	public void delete(Assurance t) {
		DaoTest.deleteAssurance(t);
		
	}

	@Override
	public Assurance findById(String... id) {
		if (DaoTest.selectAssurance(id).size()==0) {
			return null;
		}
		return DaoTest.selectAssurance(id).get(0);
	}

	@Override
	public List<Assurance> findAll() {
		return DaoTest.selectAssurance();
	}

}
