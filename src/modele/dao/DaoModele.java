package modele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.UtOracleDataSource;
import modele.dao.requetes.Requete;

public abstract class DaoModele<T> implements Dao<T> {
	protected Connection connexion = UtOracleDataSource.getConnexionBD();

	protected abstract T creerInstance(ResultSet curseur) throws SQLException;

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

	public int miseAJour(Requete<T> req, T donnee) throws SQLException {
		try (PreparedStatement prSt = connexion.prepareStatement(req.requete())) {
			req.parametres(prSt, donnee);
			return prSt.executeUpdate();
		}
	}

	public List<T> find(Requete<T> req, String... id) throws SQLException {
		try (PreparedStatement prSt = connexion.prepareStatement(req.requete())) {
			req.parametres(prSt, id);
			return select(prSt);
		}
	}

	public T findById(Requete<T> req, String... id) throws SQLException {
		List<T> res = new ArrayList<>();
		try (PreparedStatement prSt = connexion.prepareStatement(req.requete())) {
			req.parametres(prSt, id);
			res = select(prSt);
		}
		if (res.size() == 0) {
			return null;
		}
		return res.get(0);
	}

}