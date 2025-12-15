package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Paiement;

public class RequeteSelectDatePaiementByCL extends Requete<Paiement> {

	@Override
	public String requete() {
		return "Select Date_Paiement from MSF5131A.SAE_Paiement where fk_Numero_de_contrat = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
