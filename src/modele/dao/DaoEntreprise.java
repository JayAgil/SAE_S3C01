package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Entreprise;
import modele.dao.requetes.*;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

	@Override
	public void create(Entreprise t) {
		DaoTest.insertEntreprise(t);

	}

	@Override
	public void update(Entreprise t) {
		DaoTest.updateEntreprise(t);

	}

	@Override
	public void delete(Entreprise t) {
		DaoTest.deleteEntreprise(t);

	}

	@Override
	public Entreprise findById(String... id) throws SQLException {
		return findById(new RequeteSelectEntrepriseById(), id);
	}

	@Override
	public List<Entreprise> findAll() throws SQLException {
		return find(new RequeteSelectEntreprise());
	}

	@Override
	protected Entreprise creerInstance(ResultSet rs) throws SQLException {
		String numSiret = rs.getString(1);
		String adresse = rs.getString(2);
		String ville = rs.getString(3);
		String codePostal = rs.getString(4);
		String nom = rs.getString(5);
		String numTel = rs.getString(6);
		String specialite = rs.getString(7);
		return new Entreprise(numSiret, adresse, ville, codePostal, nom, numTel, specialite);
	}

}
