package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.ContratLocation;
import modele.Paiement;
import modele.dao.requetes.*;

public class DaoPaiement extends DaoModele<Paiement> implements Dao<Paiement> {

	public DaoPaiement() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int create(Paiement t) throws SQLException {
		return miseAJour(new RequeteInsertPaiement(), t);	
	}

	public int update(Paiement t) throws SQLException {
		return miseAJour(new RequeteUpdatePaiement(), t);
	}

	public int delete(Paiement t) throws SQLException {
		return this.miseAJour(new RequeteDeletePaiement(), t);
	}

	public Paiement findById(String... id) throws SQLException {
		return findById(new RequeteSelectPaiement(), id);
	}

	public List<Paiement> findAll() throws SQLException {
		return find(new RequeteSelectPaiement());
	}
	
	public Paiement findDateDernierPaiementByCL(String idCL) throws SQLException {
		return this.findById(new RequeteSelectDatePaiementByCL(),idCL);
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
