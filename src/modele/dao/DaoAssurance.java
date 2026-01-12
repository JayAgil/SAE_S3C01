package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.List;
import modele.Assurance;
import modele.Batiment;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance> {

	public DaoAssurance() throws SQLException {
		super();
	}

	/** Ajoute une assurance dans la base de données. */
	@Override
	public int create(Assurance t) throws SQLException {
		return miseAJour(new RequeteInsertAssurance(), t);
	}

	/** Met à jour une assurance existante dans la base de données. */
	@Override
	public int update(Assurance t) throws SQLException {
		return miseAJour(new RequeteUpdateAssurance(), t);
	}

	/** Supprime une assurance de la base de données. */
	@Override
	public int delete(Assurance t) throws SQLException {
		return miseAJour(new RequeteDeleteAssurance(), t);
	}

	/** Cherche une assurance par son identifiant. */
	@Override
	public Assurance findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectAssuranceById(), id);
	}

	/** Récupère toutes les assurances de la base de données. */
	@Override
	public List<Assurance> findAll() throws SQLException {
		return this.find(new RequeteSelectAssurance());
	}

	/** Cherche une assurance associée à un bâtiment donné. */
	public Assurance findByBatiment(String adresseBatiment) throws SQLException {
		return this.findById(new RequeteSelectAssuranceByBatiment(), adresseBatiment);
	}

	/** Compte le nombre de biens assurés pour un bâtiment donné. */
	public int countBiensAssures(String adresseBatiment) throws SQLException {
		String sql = "SELECT COUNT(*) FROM MSF5131A.SAE_BienLouable WHERE fk_Adresse_Bat = ?";
		try (PreparedStatement st = this.connexion.prepareStatement(sql)) {
			st.setString(1, adresseBatiment);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		return 0;
	}

	/**
	 * Crée une instance d'Assurance à partir d'un ResultSet.
	 * 
	 * @param curseur le curseur du résultat de la requête
	 * @return une instance d'Assurance
	 */
	@Override
	protected Assurance creerInstance(ResultSet curseur) throws SQLException {
		String numeroAssurance = curseur.getString(1);
		double prime = curseur.getDouble(2);
		double montant = curseur.getDouble(3);
		String typeAssurance = curseur.getString(4);
		String adresseBat = curseur.getString(8);
		DaoBatiment daoBat = new DaoBatiment();
		Batiment batiment = daoBat.findById(adresseBat);

		String agence = curseur.getString(5);
		String adresseAgence = curseur.getString(6);
		String telAgence = curseur.getString(7);

		return new Assurance(numeroAssurance, prime, montant, typeAssurance, batiment, agence, adresseAgence,
				telAgence);
	}
}