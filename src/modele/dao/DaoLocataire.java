package modele.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.ContratLocation;
import modele.Garant;
import modele.Locataire;
import modele.dao.requetes.*;;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	public DaoLocataire() throws SQLException {
		super();
	}

	/**
	 * Ajoute un nouveau locataire dans la base.
	 */
	@Override
	public int create(Locataire t) throws SQLException {
		return miseAJour(new RequeteInsertLocataire(), t);
	}

	/**
	 * Met à jour les informations d'un locataire existant.
	 */
	@Override
	public int update(Locataire t) throws SQLException {
		return miseAJour(new RequeteUpdateLocataire(), t);
	}

	/**
	 * Supprime un locataire de la base.
	 */
	@Override
	public int delete(Locataire t) throws SQLException {
		return this.miseAJour(new RequeteDeleteLocataire(), t);
	}

	/**
	 * Recherche un locataire par son identifiant.
	 * 
	 * @param id identifiant du locataire
	 * @return le locataire correspondant ou null
	 */
	@Override
	public Locataire findById(String... id) throws SQLException {
		return findById(new RequeteSelectLocataireById(), id);
	}

	/**
	 * Retourne la liste de tous les locataires.
	 */
	@Override
	public List<Locataire> findAll() throws SQLException {
		List<Locataire> result = find(new RequeteSelectLocataire());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Recherche les locataires d'un bien louable spécifique.
	 */
	public List<Locataire> findLocataireByBienLouable(String... id) throws SQLException {
		List<Locataire> result = find(new RequeteSelectLocataireByBienLouable(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Recherche les locataires associés à un contrat spécifique.
	 */
	public List<Locataire> findLocataireByContrat(String... id) throws SQLException {
		List<Locataire> result = find(new RequeteSelectLocataireByContrat(), id);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Recherche les locataires vivant dans le même bien qu'un locataire donné.
	 */
	public List<Locataire> findLocatairesMemeBien(String idLoc) throws SQLException {
		List<Locataire> result = this.find(new RequeteSelectLocatairesMemeBien(), idLoc);
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée la relation entre un locataire et un contrat dans la table de liaison.
	 */
	public int createContratLocataire(Locataire loc, ContratLocation cl) throws SQLException {
		RequeteInsertContratLocataire reqCL = new RequeteInsertContratLocataire();
		try (PreparedStatement ps = connexion.prepareStatement(reqCL.requete())) {
			reqCL.parametres(ps, loc.getIdLocataire(), cl.getNumeroDeContrat());
			return ps.executeUpdate();
		}
	}

	/**
	 * Crée une instance Locataire à partir du ResultSet.
	 */
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
