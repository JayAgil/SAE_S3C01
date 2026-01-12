package modele.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.UtOracleDataSource;
import modele.dao.requetes.Requete;

public abstract class DaoModele<T> implements Dao<T> {
	
	protected Connection connexion;
	
	/**
     * Constructeur de DAO.
     * Initialise la connexion à la base de données à partir de UtOracleDataSource.
     * 
     * @throws SQLException si la connexion n'est pas initialisée
     */
	public DaoModele() throws SQLException {
	    this.connexion = UtOracleDataSource.getConnectionBD();
	    if (this.connexion == null) {
	        throw new SQLException("Database connection not initialized. Call CreerAcces() first.");
	    }
	}

	/**
     * Crée une instance de l'entité T à partir d'un ResultSet.
     * Doit être implémenté dans chaque DAO spécifique.
     * 
     * @param curseur le ResultSet provenant de la requête
     * @return instance de T
     * @throws SQLException si une erreur SQL survient
     */
	protected abstract T creerInstance(ResultSet curseur) throws SQLException;
	
	/**
     * Exécute une requête SELECT et construit la liste d'objets T.
     * 
     * @param prSt PreparedStatement prêt à être exécuté
     * @return liste des objets résultants
     * @throws SQLException si une erreur SQL survient
     */
	protected List<T> select(PreparedStatement prSt) throws SQLException {
		List<T> res = new ArrayList<>();
		try (ResultSet rs = prSt.executeQuery()) {
			while (rs.next()) {
				T element = creerInstance(rs);
				res.add(element);
			}
		}
		return res;
	}

	/**
     * Exécute une requête INSERT, UPDATE ou DELETE.
     * 
     * @param req requête préparée avec paramètres pour l'objet
     * @param donnee l'objet T à insérer, mettre à jour ou supprimer
     * @return nombre de lignes affectées
     * @throws SQLException si une erreur SQL survient
     */
    public int miseAJour(Requete<T> req, T donnee) throws SQLException {
        try (PreparedStatement prSt = connexion.prepareStatement(req.requete())) {
            req.parametres(prSt, donnee);
            return prSt.executeUpdate();
        }
    }

    /**
     * Exécute une requête SELECT générique et retourne la liste des objets T.
     * 
     * @param req la requête SQL avec paramètres
     * @param id paramètres à passer à la requête
     * @return liste des objets T
     * @throws SQLException si une erreur SQL survient
     */
    public List<T> find(Requete<T> req, String... id) throws SQLException {
        try (PreparedStatement prSt = connexion.prepareStatement(req.requete())) {
            req.parametres(prSt, id);
            return select(prSt);
        }
    }

    /**
     * Exécute une requête SELECT et retourne le premier élément trouvé.
     * Utile pour les recherches par identifiant.
     * 
     * @param req la requête SQL avec paramètres
     * @param id paramètres à passer à la requête
     * @return le premier objet T trouvé, ou null si aucun résultat
     * @throws SQLException si une erreur SQL survient
     */
    public T findById(Requete<T> req, String... id) throws SQLException {
        List<T> res = new ArrayList<>();
        try (PreparedStatement prSt = connexion.prepareStatement(req.requete())) {
            req.parametres(prSt, id);
            res = select(prSt);
        }
        if (res.isEmpty()) {
            return null;
        }
        return res.get(0);
    }

}