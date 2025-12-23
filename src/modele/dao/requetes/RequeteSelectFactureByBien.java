package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

public class RequeteSelectFactureByBien extends Requete<Facture> {

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Facture where fk_Id_BienLouable = ?";

	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
