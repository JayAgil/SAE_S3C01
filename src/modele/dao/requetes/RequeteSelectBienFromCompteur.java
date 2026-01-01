package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienFromCompteur extends Requete<BienLouable>{
	
	public String requete() {
	    return "SELECT bl.* "
	    		+ "FROM MSF5131A.SAE_BienLouable bl "
	    		+ "JOIN MSF5131A.SAE_Compteur c "
	    		+ "  ON c.fk_Id_BienLouable = bl.Id_BienLouable "
	    		+ "WHERE c.Id_Compteur = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
