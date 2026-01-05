package modele.dao.requetes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ChargesGenerales;

public class RequeteInsertChargeGenerale extends Requete<ChargesGenerales>{

	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Charges_Generale VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, ChargesGenerales cg) throws SQLException {
		 	ps.setString(1, cg.getIdChargesGenerales());          
		    ps.setString(2, cg.getTypeCharge());          
		    ps.setDouble(3, cg.getMontant());                
		    ps.setDouble(4, cg.getPourcentage());       
		    ps.setDouble(5, cg.getQuotite());            
		    ps.setDate(6, cg.getDateCharge());        
		    ps.setString(7, cg.getBienLouable().getIdBienLouable());    
    }

}
