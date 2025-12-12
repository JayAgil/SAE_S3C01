package modele;

import java.sql.SQLException;

import modele.dao.DaoBienLouable;

public class Test {
	public static void main(String[] args) throws SQLException {
	    UtOracleDataSource.CreerAcces("NRK4981A", "abcd123");
	    DaoBienLouable dbl = new DaoBienLouable();
	    for (BienLouable b : dbl.findAll()) {
	    	System.out.println(b.toString());
	    }
	}
}
