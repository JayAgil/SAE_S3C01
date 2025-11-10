package modele.dao;

import java.util.List;

import modele.Entreprise;

public class DaoEntreprise implements Dao<Entreprise> {

	@Override
	public void create(Entreprise t) {
		DaoTest.insertEntreprise(t);
		
	}

	@Override
	public void update(Entreprise t) {
		DaoTest.updateEntreprise(t);
		
	}

	@Override
	public void delete(Entreprise t) {
		DaoTest.deleteEntreprise(t);
		
	}

	@Override
	public Entreprise findById(String... id) {
		if (DaoTest.selectEntreprise(id).size()==0) {
			return null;
		}
		return DaoTest.selectEntreprise(id).get(0);
	}

	@Override
	public List<Entreprise> findAll() {
		return DaoTest.selectEntreprise();
	}

}
