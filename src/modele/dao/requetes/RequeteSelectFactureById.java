package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

public class RequeteSelectFactureById extends Requete<Facture>{

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Facture where numero_Facture = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}


}
