package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Paiement;

public class RequeteSelectPaiementById extends Requete<Paiement>{

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_PAIEMENT where id_paiement = ?";
	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
	
}
