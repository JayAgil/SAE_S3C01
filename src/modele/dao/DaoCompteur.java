package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.BienLouable;
import modele.Compteur;

public class DaoCompteur extends DaoModele<Compteur> implements Dao<Compteur> {

	@Override
	public void create(Compteur t) {
		DaoTest.insertCompteur(t);
		
	}

	@Override
	public void update(Compteur t) {
		DaoTest.updateCompteur(t);
		
	}

	@Override
	public int delete(Compteur t) {
		DaoTest.deleteCompteur(t);
		
	}

	@Override
	public Compteur findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectCompteurById(), id);
	}

	@Override
	public List<Compteur> findAll() throws SQLException {
		return this.find(new RequeteSelectCompteur());
	}

	@Override
	protected Compteur creerInstance(ResultSet curseur) throws SQLException {
		// TODO Auto-generated method stub
		String id_Compteur = curseur.getString(1);
		double partie_fixe = curseur.getDouble(2);
		double partie_variable = curseur.getDouble(3);
		double total = curseur.getDouble(4);
		String type = curseur.getString(5);
		Date d = curseur.getDate(6);
		double index_ancien = curseur.getDouble(7);
		double index_nouveau = curseur.getDouble(8);
		String id = curseur.getString(6);
		DaoBienLouable daoBL = new DaoBienLouable();
		BienLouable bl = daoBL.findById(id);
		return new Compteur(id_Compteur,partie_fixe,partie_variable,total,d,bl,index_ancien,index_nouveau,type);
	}

}
