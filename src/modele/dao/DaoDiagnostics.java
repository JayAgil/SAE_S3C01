package modele.dao;

import java.util.List;

import modele.Diagnostics;

public class DaoDiagnostics implements Dao<Diagnostics> {

	@Override
	public void create(Diagnostics t) {
		DaoTest.insertDiagnostics(t);
		
	}

	@Override
	public void update(Diagnostics t) {
		DaoTest.updateDiagnostics(t);
		
	}

	@Override
	public void delete(Diagnostics t) {
		DaoTest.deleteDiagnostics(t);
		
	}

	@Override
	public Diagnostics findById(String... id) {
		if (DaoTest.selectDiagnostics(id).size()==0) {
			return null;
		}
		return DaoTest.selectDiagnostics(id).get(0);
	}

	@Override
	public List<Diagnostics> findAll() {
		return DaoTest.selectDiagnostics();
	}

}
