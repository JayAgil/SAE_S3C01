package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.BienLouable;
import modele.ChargesGenerales;

public class DaoChargesGenerales extends DaoModele<ChargesGenerales>implements Dao<ChargesGenerales> {

	public DaoChargesGenerales() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(ChargesGenerales t) throws SQLException {
		return miseAJour(new RequeteInsertChargeGenerale(), t);
		
	}

	@Override
	public int update(ChargesGenerales t) throws SQLException {
		return miseAJour(new RequeteUpdateChargesGenerales(), t);
	}

	@Override
	public int delete(ChargesGenerales t) throws SQLException {
		return miseAJour(new RequeteDeleteChargesGenerales(), t);
		
	}

	@Override
	public ChargesGenerales findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectChargesGeneralesById(),id);
	}
	
	public List<ChargesGenerales> findByIdBatiment(String... id) throws SQLException {
		return this.find(new RequeteSelectChargesByBatiment(),id);
	}
	
	public List<ChargesGenerales> findByIdBien(String... id) throws SQLException {
		return this.find(new RequeteSelectChargesByBien(),id);
	}
	
	@Override
	public List<ChargesGenerales> findAll() throws SQLException {
		return this.find(new RequeteSelectChargesGenerales());
	}

	@Override
	protected ChargesGenerales creerInstance(ResultSet curseur) throws SQLException {
		String id_ChargesGenerale = curseur.getString(1);
		String type = curseur.getString(2);
		double montant = curseur.getDouble(3);
		float pourcentage = curseur.getFloat(4);
		double quotite = curseur.getDouble(5);
		Date dateCharge = curseur.getDate(6);
		String id = curseur.getString(7);
		DaoBienLouable daoBL = new DaoBienLouable();
		BienLouable bl = daoBL.findById(id);
		return new ChargesGenerales(id_ChargesGenerale,type,montant,pourcentage,quotite,dateCharge,bl);
	}

}
