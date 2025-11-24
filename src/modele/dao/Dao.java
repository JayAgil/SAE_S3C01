package modele.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	public void create(T t) throws SQLException;
	
	public void update(T t) throws SQLException;
	
	public int delete(T t) throws SQLException;
	
	public T findById(String...id) throws SQLException;
	
	public List<T> findAll() throws SQLException;


}
