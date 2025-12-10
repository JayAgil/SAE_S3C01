package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Paiement;

public class RequeteSelectPaiement extends Requete<Paiement> {

	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_PAIEMENT";
	}
	

}
