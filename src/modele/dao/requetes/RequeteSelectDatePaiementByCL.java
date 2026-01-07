package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;
import modele.Paiement;

public class RequeteSelectDatePaiementByCL extends Requete<Paiement> {
	
	public String requete() {
		return " Select * from MSF5131A.SAE_Paiement where fk_Numero_de_contrat = ? order by Date_Paiement DESC" ;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, ContratLocation donnee) {
		
	}

}
