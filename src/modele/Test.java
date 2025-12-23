package modele;

import java.sql.SQLException;

import modele.dao.DaoBienLouable;

public class Test {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	public static void main(String[] args) throws SQLException {
	    UtOracleDataSource.CreerAcces("NRK4981A", "abcd123");
	    DaoBienLouable dbl = new DaoBienLouable();
	    for (BienLouable b : dbl.findAll()) {
	    	System.out.println(b.toString());
	    }
=======
=======
>>>>>>> Stashed changes

	public static void main(String[] args) throws SQLException {
		DaoBienLouable dbl = new DaoBienLouable();
		for (BienLouable b : dbl.findAll()) {
			System.out.println(b.toString());
		}
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
	}
}
