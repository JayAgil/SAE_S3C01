package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;
import modele.Facture;

public class RequeteSelectDateFactureByBien extends Requete<Facture> {
	
	public String requete() {
		return " Select * from MSF5131A.SAE_Facture where fk_Id_BienLouable = ? Order by Date_de_facture DESC" ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, ContratLocation donnee) {
		
	}

}
