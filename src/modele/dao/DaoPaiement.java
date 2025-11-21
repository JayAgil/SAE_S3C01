package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.ContratLocation;
import modele.Paiement;
import modele.dao.requetes.*;

public class DaoPaiement extends DaoModele<Paiement> implements Dao<Paiement> {
	

	public void create(Paiement t) {
		DaoTest.insertPaiement(t);
		
	}

	public void update(Paiement t) {
		DaoTest.updatePaiement(t);
		
	}

	public void delete(Paiement t) {
		DaoTest.deletePaiement(t);
		
	}

	public Paiement findById(String... id) throws SQLException {
		return findById(new RequeteSelectPaiement(), id);
	}

	public List<Paiement> findAll() throws SQLException {
		return find(new RequeteSelectPaiement());
	}

	@Override
	protected Paiement creerInstance(ResultSet rs) throws SQLException {
		DaoContratLocation dCL = new DaoContratLocation();
		String idpaiement = rs.getString(1);
		Double montant = rs.getDouble(2);
		Date datePaiement = rs.getDate(3);
		ContratLocation cl = dCL.findById(rs.getString(4));
		return new Paiement(idpaiement, montant, datePaiement, cl);
	}

}
