package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Paiement;

public class RequeteInsertPaiement extends Requete<Paiement>{
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_PAIEMENT VALUES (?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Paiement p) throws SQLException {
		 ps.setString(1, p.getId_paiement());          
		    ps.setDouble(2, p.getMontant());          
		    ps.setDate(3, p.getDatepaiement());                
		    ps.setString(4, p.getContratLocation().getNumeroDeContrat());       
    }
}
