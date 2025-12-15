package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

public class RequeteSelectDateFactureByBien extends Requete<Facture> {
	
	@Override
	public String requete() {
		return "Select Date_de_facture from MSF5131A.SAE_Facture where fk_Id_BienLouable = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
