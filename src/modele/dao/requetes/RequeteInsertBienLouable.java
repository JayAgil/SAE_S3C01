package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteInsertBienLouable extends Requete<BienLouable> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_BienLouable VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, BienLouable b) throws SQLException {
		 ps.setString(1, b.getIdBienLouable());          
		    ps.setString(2, b.getNumeroFiscale());          
		    ps.setString(3, b.getAdresse());                
		    ps.setDouble(4, b.getSurfaceHabituable());       
		    ps.setInt(5, b.getNbPieces());            
		    ps.setString(6, b.getTypeBienLouable());        
		    ps.setString(7, b.getLogement().getIdBienLouable());    
		    ps.setString(8, b.getBatiment().getAdresse());

        
    }

}
