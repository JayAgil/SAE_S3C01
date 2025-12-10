package modele.dao.requetes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.BienLouable;

public class RequeteDeleteBienLouable extends Requete<BienLouable>{
	public String requete() {
		return " Delete from MSF5131A.SAE_BienLouable  where id_bienLouable = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
