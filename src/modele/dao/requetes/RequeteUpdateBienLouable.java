package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteUpdateBienLouable extends Requete<BienLouable> {
    @Override
    public String requete() {
    	return "UPDATE MSF5131A.SAE_BienLouable SET " +
    	           "NumeroFiscale = ?, " +
    	           "Adresse = ?, " +
    	           "Surface_d_habituable = ?, " +
    	           "Nombre_de_pieces = ?, " +
    	           "Type_bien_louable = ?, " +
    	           "Id_BienLouable_2 = ?, " +
    	           "fk_Adresse_Bat = ? " +
    	           "WHERE Id_BienLouable = ?";
    }

    @Override
    public void parametres(PreparedStatement ps, BienLouable b)
        throws SQLException {
    	ps.setString(1, b.getIdBienLouable());          
	    ps.setString(2, b.getNumeroFiscale());          
	    ps.setString(3, b.getAdresse());                
	    ps.setDouble(4, b.getSurfaceHabituable());       
	    ps.setInt(5, b.getNbPieces());            
	    ps.setString(6, b.getTypeBienLouable());        
	    ps.setString(7, b.getLogement());    
	    ps.setString(8, b.getBatiment().getAdresse());
    }

}
