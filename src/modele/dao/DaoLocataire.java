package modele.dao;

import java.util.List;

import modele.Locataire;

public class DaoLocataire implements Dao<Locataire> {

	@Override
	public void create(Locataire t) {
		DaoTest.insertLocataire(t);
		
	}

	@Override
	public void update(Locataire t) {
		DaoTest.updateLocataire(t);
		
	}

	@Override
	public void delete(Locataire t) {
		DaoTest.deleteLocataire(t);
		
	}

	@Override
	public Locataire findById(String... id) {
		if (DaoTest.selectLocataire(id).size()==0) {
			return null;
		}
		return DaoTest.selectLocataire(id).get(0);
	}

	@Override
	public List<Locataire> findAll() {
		return DaoTest.selectLocataire();
	}

}
