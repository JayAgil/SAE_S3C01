package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienByIdCharge extends Requete<BienLouable>{
	
	@Override
	public String requete() {
	    return "SELECT bl.* "
	         + "FROM MSF5131A.SAE_BienLouable bl "
	         + "JOIN MSF5131A.SAE_Charges_Generale cg "
	         + "    ON cg.fk_Id_BienLouable = bl.Id_BienLouable "
	         + "WHERE cg.Id_Charges_Generale = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
