package modele.dao;

import java.util.List;

import modele.Compteur;

public class DaoCompteur implements Dao<Compteur> {

	@Override
	public void create(Compteur t) {
		DaoTest.insertCompteur(t);
		
	}

	@Override
	public void update(Compteur t) {
		DaoTest.updateCompteur(t);
		
	}

	@Override
	public void delete(Compteur t) {
		DaoTest.deleteCompteur(t);
		
	}

	@Override
	public Compteur findById(String... id) {
		if (DaoTest.selectCompteur(id).size()==0) {
			return null;
		}
		return DaoTest.selectCompteur(id).get(0);
	}

	@Override
	public List<Compteur> findAll() {
		return DaoTest.selectCompteur();
	}

}
