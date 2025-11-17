package Connection;
<<<<<<< HEAD

=======
>>>>>>> 0d5c8b3dea9b3ffcd816f58f9454b617a7a0f81d
import java.sql.*;
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
