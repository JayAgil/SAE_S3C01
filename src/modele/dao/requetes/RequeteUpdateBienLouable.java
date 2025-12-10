package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteUpdateBienLouable extends Requete<BienLouable> {
    @Override
    public String requete() {
    	return "UPDATE SAE_BienLouable SET " +
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
<<<<<<< HEAD
        throws SQLException {
=======
        throws SQLException {          
>>>>>>> f986a6962a15ff489088103eeb2fd520103b21e1
	    ps.setString(1, b.getNumeroFiscale());          
	    ps.setString(2, b.getAdresse());                
	    ps.setDouble(3, b.getSurfaceHabituable());       
	    ps.setInt(4, b.getNbPieces());            
	    ps.setString(5, b.getTypeBienLouable());        
<<<<<<< HEAD
	    ps.setString(6, b.getLogement().getIdBienLouable());    
	    ps.setString(7, b.getBatiment().getAdresse());
	    ps.setString(8, b.getIdBienLouable());

=======
	    ps.setString(6, b.getLogement());    
	    ps.setString(7, b.getBatiment().getAdresse());
	    ps.setString(8, b.getIdBienLouable()); 
>>>>>>> f986a6962a15ff489088103eeb2fd520103b21e1
    }

}
