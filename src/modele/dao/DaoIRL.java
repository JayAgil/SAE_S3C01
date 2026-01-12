package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.IRL;
import modele.dao.requetes.*;

public class DaoIRL extends DaoModele<IRL> implements Dao<IRL> {

	public DaoIRL() throws SQLException {
		super();
	}

	/**
	 * Ajoute un nouvel IRL dans la base de données.
	 */
	@Override
	public int create(IRL t) throws SQLException {
		return this.miseAJour(new RequeteInsertIRL(), t);
	}

	/** La suppression d'un IRL n'est pas implémentée. */
	@Override
	public int delete(IRL t) throws SQLException {
		return 0;
	}



	/**
	 * Recherche un IRL selon l'année et éventuellement le trimestre.
	 * 
	 * @param id tableau contenant : - id[0] = année - id[1] = trimestre (optionnel)
	 * @return l'IRL correspondant ou null si non trouvé
	 */
    @Override
    public IRL findById(String... id) throws SQLException {
        if (id.length == 2) {
            return findById(new RequeteSelectIRLById(), id[0], id[1]);
        }
        return null;
    }


	/**
	 * Retourne la liste de tous les IRL.
	 */
	@Override
	public List<IRL> findAll() throws SQLException {
		List<IRL> result = find(new RequeteSelectIRL());
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Crée une instance IRL à partir du ResultSet.
	 * 
	 * @param rs curseur de la requête
	 * @return un objet IRL
	 * @throws SQLException
	 */
	@Override
	protected IRL creerInstance(ResultSet rs) throws SQLException {
		int annee = rs.getInt("Annee");
		int trimestre = rs.getInt("Trimestre");
		double valeur = rs.getDouble("IRL");
		return new IRL(annee, trimestre, valeur);
	}

	/** La mise à jour d'un IRL n'est pas implémentée. */
	@Override
	public int update(IRL t) throws SQLException {
		return 0;
	}
}
