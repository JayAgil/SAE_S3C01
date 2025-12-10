package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Batiment;

public class RequeteDeleteBatiment extends Requete<Batiment> {
	public String requete() {
		return " Delete from MSF5131A.SAE_Batiment  where adresse = ? " ;
		
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}


}
