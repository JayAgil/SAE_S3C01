package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteSelectContratLocationFromOneContratUnderTheBatiment extends Requete<ContratLocation>{

	@Override
	public String requete() {
		return "SELECT c2.* " +
	            "FROM MSF5131A.SAE_ContratLocation c1 " +
	            "JOIN MSF5131A.SAE_BienLouable b1 ON c1.fk_Id_BienLouable = b1.Id_BienLouable " +
	            "JOIN MSF5131A.SAE_BienLouable b2 ON b2.fk_Adresse_Bat = b1.fk_Adresse_Bat " +
	            "JOIN MSF5131A.SAE_ContratLocation c2 ON c2.fk_Id_BienLouable = b2.Id_BienLouable " +
	            "WHERE c1.Numero_de_contrat = ?";
	}
	
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }
}
