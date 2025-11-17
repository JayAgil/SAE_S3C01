package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import modele.Garant;
import modele.Locataire;
import modele.dao.requetes.*;;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	@Override
	public void create(Locataire t) {
		DaoTest.insertLocataire(t);

	}

	@Override
	public void update(Locataire t) {
		DaoTest.updateLocataire(t);

	}

	@Override
	public void delete(Locataire t) {
		DaoTest.deleteLocataire(t);

	}

	@Override
	public Locataire findById(String... id) throws SQLException {
		return findById(new RequeteSelectLocataireById(), id);
	}

	@Override
	public List<Locataire> findAll() throws SQLException {
		return find(new RequeteSelectLocataire());
	}

	@Override
	protected Locataire creerInstance(ResultSet rs) throws SQLException {
		DaoGarant dG = new DaoGarant();
		String idLocataire = rs.getString(1);
		String nom = rs.getString(2);
		String prenom = rs.getString(3);
		String adresse = rs.getString(4);
		String tel = rs.getString(5);
		String email = rs.getString(6);
		String codePostal = rs.getString(7);
		String ville = rs.getString(8);
		Date dateDeNaissance = rs.getDate(9);
		String lieuDeNaissance = rs.getString(10);
		double salaire = rs.getDouble(11);
		String profession = rs.getString(12);
		String situationFamiliale = rs.getString(13);
		String image = rs.getString(14);
		Garant garant = dG.findById(rs.getString(15));
		return new Locataire(idLocataire, nom, prenom, adresse, tel, email, codePostal, ville, dateDeNaissance, lieuDeNaissance, salaire, profession, situationFamiliale, image, garant);
	}

}
