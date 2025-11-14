package MVC;
import java.sql.*;

public class Connector {
	private static String URL = "jdbc:mysql://srv2000.hstgr.io/u994043709_SAE_DB";
	private static String user ="u994043709_SAE_User";
	private static String password="2tLi0hA?!";
	private Connector() {
		
	}
	public static Connection getConnection()throws SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection(URL,user,password);
		return connection;
	}
}
