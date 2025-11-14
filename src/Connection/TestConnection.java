package DAO;
import java.sql.*;
import MVC.Connector;
public class TestConnection {
	public static void main(String[]args) throws SQLException{
		Connection con = Connector.getConnection();
		
		if (con != null) {
			System.out.println("Connexion réussie");
		}
		else {
			System.out.println("Connexion Ratée");
		}
	}
}	
