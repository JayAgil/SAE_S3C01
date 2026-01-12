package modele.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	/** Ajoute un objet dans la base de données. */
	int create(T t) throws SQLException;

	/** Met à jour un objet existant dans la base de données. */
	int update(T t) throws SQLException;

	/** Supprime un objet de la base de données. */
	int delete(T t) throws SQLException;

	/** Cherche un objet par son identifiant. */
	T findById(String... id) throws SQLException;

	/** Récupère tous les objets de ce type. */
	List<T> findAll() throws SQLException;

}
