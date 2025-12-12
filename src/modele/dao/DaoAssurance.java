package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Batiment;

public class DaoAssurance extends DaoModele<Assurance>implements Dao<Assurance> {

	public DaoAssurance() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Assurance t) throws SQLException {
		return miseAJour(new RequeteInsertAssurance(), t);	
	}

	@Override
	public int update(Assurance t) throws SQLException {
		return miseAJour(new RequeteUpdateAssurance(), t);
	}

	@Override
	public int delete(Assurance t) throws SQLException {
		return miseAJour(new RequeteDeleteAssurance(), t);
	}

	@Override
	public Assurance findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectAssuranceById(), id);
	}

	@Override
	public List<Assurance> findAll() throws SQLException {
		return this.find(new RequeteSelectAssurance());
	}

	@Override
	protected Assurance creerInstance(ResultSet curseur) throws SQLException {
		String numeroAssurance= curseur.getString(1);
		double prime = curseur.getDouble(2);
		double montant = curseur.getDouble(3);
		String typeAssurance = curseur.getString(4);
		String adresseBat = curseur.getString(8);
		DaoBatiment daoBat = new DaoBatiment();
		Batiment batiment = daoBat.findById(adresseBat) ;
		String agence = curseur.getString(5);
		String adresseAgence = curseur.getString(6);
		String telAgence = curseur.getString(7); 
		return new Assurance (numeroAssurance,prime,montant,
				typeAssurance,batiment,agence,adresseAgence,telAgence);
	}

}
