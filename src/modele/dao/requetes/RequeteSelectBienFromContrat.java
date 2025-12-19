package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienFromContrat extends Requete<BienLouable>{

	@Override
	public String requete() {
	    return "SELECT b.* FROM MSF5131A.SAE_BienLouable b " +
	           "JOIN MSF5131A.SAE_ContratLocation c ON b.Id_BienLouable = c.fk_Id_BienLouable " +
	           "WHERE c.Numero_de_Contrat = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
