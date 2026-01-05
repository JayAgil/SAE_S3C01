package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.IRL;

public class RequeteInsertIRL extends Requete<IRL>{

	
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_IRL (Annee, IRL, Trimestre) VALUES (?,?,?)";
	}
	
	public void parametres(PreparedStatement ps, IRL i) throws SQLException {
        ps.setLong(1, i.getAnnee());
        ps.setDouble(2, i.getIRL());
        ps.setInt(3, i.getTrimestre());
    }

}
