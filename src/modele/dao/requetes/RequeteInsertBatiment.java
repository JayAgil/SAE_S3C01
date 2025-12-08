package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

public class RequeteInsertBatiment extends Requete<Batiment> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO SAE_BATIMENT VALUES (?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Batiment a) throws SQLException {
        ps.setString(1, a.getAdresse());
        ps.setDate(2, a.getDateConstruction());
        
    }

	
}
