package modele.dao;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Batiment;
import modele.BienLouable;

public class DaoBienLouable extends DaoModele<BienLouable> implements Dao<BienLouable> {

	public DaoBienLouable() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(BienLouable t) throws SQLException {
		return miseAJour(new RequeteInsertBienLouable(), t);
		
	}

	@Override
	public int update(BienLouable t) throws SQLException {
		return miseAJour(new RequeteUpdateBienLouable(), t);
		
	}

	@Override
	public int delete(BienLouable t) throws SQLException {
		return miseAJour(new RequeteDeleteBienLouable(), t);
	}

	@Override
	public BienLouable findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectBienLouableById(), id);
	}

	@Override
	public List<BienLouable> findAll() throws SQLException {
		return this.find(new RequeteSelectBienLouable());
	}

	@Override
	protected BienLouable creerInstance(ResultSet curseur) throws SQLException {
		String id_bienLouable = curseur.getString(1);
		String numFiscale = curseur.getString(2);
		String adresse = curseur.getString(3);
		double surface = curseur.getDouble(4);
		int nbPieces = curseur.getInt(5);
		String typeBienLouable = curseur.getString(6);
		String a = curseur.getString(8);
		DaoBatiment daoBat = new DaoBatiment();
		Batiment b = daoBat.findById(a);
		String id = curseur.getString(7);
		DaoBienLouable daoBl = new DaoBienLouable();
		BienLouable bl = daoBl.findById(id);
		
		return new BienLouable(id_bienLouable,numFiscale,adresse,surface,nbPieces,typeBienLouable, b,bl );
	}

}
