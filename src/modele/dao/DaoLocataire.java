package modele.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.ContratLocation;
import modele.Garant;
import modele.Locataire;
import modele.dao.requetes.*;;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	public DaoLocataire() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Locataire t) throws SQLException {
		return miseAJour(new RequeteInsertLocataire(), t);
	}

	@Override
	public int update(Locataire t) throws SQLException {
		return miseAJour(new RequeteUpdateLocataire(), t);

	}

	@Override
	public int delete(Locataire t) throws SQLException {
		return this.miseAJour(new RequeteDeleteLocataire(), t);
	}

	@Override
	public Locataire findById(String... id) throws SQLException {
		return findById(new RequeteSelectLocataireById(), id);
	}

	@Override
	public List<Locataire> findAll() throws SQLException {
		return find(new RequeteSelectLocataire());
	}

	public List<Locataire> findLocataireByBienLouable(String... id) throws SQLException {
		return find(new RequeteSelectLocataireByBienLouable(), id);
	}

	public List<Locataire> findLocataireByContrat(String... id) throws SQLException {
		return find(new RequeteSelectLocataireByContrat(), id);
	}

	public List<Locataire> findLocatairesMemeBien(String idLoc) throws SQLException {
		return this.find(new RequeteSelectLocatairesMemeBien(), idLoc);
	}

	public int createContratLocataire(Locataire loc, ContratLocation cl) throws SQLException {
		RequeteInsertContratLocataire reqCL = new RequeteInsertContratLocataire();
		try (PreparedStatement ps = connexion.prepareStatement(reqCL.requete())) {
			reqCL.parametres(ps, loc.getIdLocataire(), cl.getNumeroDeContrat());

			return ps.executeUpdate();
		}
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
		Garant garant = dG.findById(rs.getString(14));
		return new Locataire(idLocataire, nom, prenom, adresse, tel, email, codePostal, ville, dateDeNaissance,
				lieuDeNaissance, salaire, profession, situationFamiliale, garant);
	}

}
