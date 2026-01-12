package modele.dao.requetes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.BienLouable;

public class RequeteDeleteBienLouable extends Requete<BienLouable>{
	public String requete() {
		return "Delete from MSF5131A.SAE_BienLouable where Id_BienLouable = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, BienLouable bl) throws SQLException {
		prSt.setString(1, bl.getIdBienLouable());
	}

}
