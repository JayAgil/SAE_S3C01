package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.BienLouable;
import modele.ChargesGenerales;

public class DaoChargesGenerales extends DaoModele<ChargesGenerales>implements Dao<ChargesGenerales> {

	@Override
	public void create(ChargesGenerales t) {
		DaoTest.insertChargesGenerales(t);
		
	}

	@Override
	public void update(ChargesGenerales t) {
		DaoTest.updateChargesGenerales(t);
		
	}

	@Override
	public int delete(ChargesGenerales t) {
		DaoTest.deleteChargesGenerales(t);
		
	}

	@Override
	public ChargesGenerales findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectChargesGeneralesById(),id);
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
		String id = curseur.getString(6);
		DaoBienLouable daoBL = new DaoBienLouable();
		BienLouable bl = daoBL.findById(id);
		return new ChargesGenerales(id_ChargesGenerale,type,montant,pourcentage,quotite,bl);
	}

}
