package modele.dao;

import java.util.List;

import modele.Facture;

public class DaoFacture implements Dao<Facture> {

	@Override
	public void create(Facture t) {
		DaoTest.insertFacture(t);
		
	}

	@Override
	public void update(Facture t) {
		DaoTest.updateFacture(t);
		
	}

	@Override
	public void delete(Facture t) {
		DaoTest.deleteFacture(t);
		
	}

	@Override
	public Facture findById(String... id) {
		if (DaoTest.selectFacture(id).size()==0) {
			return null;
		}
		return DaoTest.selectFacture(id).get(0);
	}

	@Override
	public List<Facture> findAll() {
		return DaoTest.selectFacture();
	}

}
