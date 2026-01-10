package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteSelectContratLocationByBatiment extends Requete<ContratLocation>{

	@Override
	public String requete() {
		return "SELECT c.* " +
                "FROM SAE_ContratLocation c " +
                "JOIN SAE_BienLouable b ON c.fk_Id_BienLouable = b.Id_BienLouable " +
                "WHERE b.fk_Adresse_Bat = ?";

	}
	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
