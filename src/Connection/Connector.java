package Connection;
<<<<<<< HEAD

import java.sql.*;
=======
>>>>>>> 0d5c8b3dea9b3ffcd816f58f9454b617a7a0f81d

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
