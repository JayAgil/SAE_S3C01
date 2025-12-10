package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

public class RequeteInsertBatiment extends Requete<Batiment> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_Batiment VALUES (?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Batiment a) throws SQLException {
        ps.setString(1, a.getAdresse());
        ps.setDate(2, a.getDateConstruction());
        
    }

	
}
