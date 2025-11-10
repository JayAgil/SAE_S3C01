package modele.dao;

import java.util.List;

import modele.Paiement;

public class DaoPaiement implements Dao<Paiement> {

	@Override
	public void create(Paiement t) {
		DaoTest.insertPaiement(t);
		
	}

	@Override
	public void update(Paiement t) {
		DaoTest.updatePaiement(t);
		
	}

	@Override
	public void delete(Paiement t) {
		DaoTest.deletePaiement(t);
		
	}

	@Override
	public Paiement findById(String... id) {
		if (DaoTest.selectPaiement(id).size()==0) {
			return null;
		}
		return DaoTest.selectPaiement(id).get(0);
	}

	@Override
	public List<Paiement> findAll() {
		return DaoTest.selectPaiement();
		
	}

}
