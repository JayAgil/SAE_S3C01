package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

public class RequeteInsertGarant extends Requete<Garant> {
	
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Garant VALUES (?,?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Garant g) throws SQLException {
        ps.setString(1, g.getIdGarant());
        ps.setString(2, g.getNom());
        ps.setString(3, g.getPrenom());
        ps.setString(4, g.getAdresse());
        ps.setString(5, g.getTel());
    }


}
