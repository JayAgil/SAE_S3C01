package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienFromContrat extends Requete<BienLouable>{

	@Override
	public String requete() {
		return "SELECT b.* FROM BienLouable b " +
	             "JOIN ContratLocation c ON b.idBienLouable = c.idBienLouable " +
	             "WHERE c.numeroDeContrat = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
