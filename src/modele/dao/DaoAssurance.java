package modele.dao;

import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Batiment;

public class DaoAssurance extends DaoModele<Assurance>implements Dao<Assurance> {

	@Override
	public void create(Assurance t) {
		DaoTest.insertAssurance(t);
	
	}

	@Override
	public void update(Assurance t) {
		DaoTest.updateAssurance(t);
		
	}

	@Override
	public void delete(Assurance t) {
		DaoTest.deleteAssurance(t);
		
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
		String adresseBat = curseur.getString(5);
		DaoBatiment daoBat = new DaoBatiment();
		Batiment batiment = daoBat.findById(adresseBat) ;
		String agence = curseur.getString(6);
		String adresseAgence = curseur.getString(7);
		String telAgence = curseur.getString(8); 
		return new Assurance (numeroAssurance,prime,montant,
				typeAssurance,batiment,agence,adresseAgence,telAgence);
	}

}
