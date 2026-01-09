package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteInsertDiagnostics extends Requete<Diagnostics> {
	
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Diagnostics VALUES (?,?,?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Diagnostics d) throws SQLException {
        ps.setString(1, d.getIdDiagnostics());
        ps.setString(2, d.getTypeDiagnostics());
        ps.setDate(3, d.getDateRealisation());
        ps.setDate(4, d.getDateValidite());
        ps.setString(5, d.getFichier());
        ps.setString(6, d.getBienLouable().getIdBienLouable());
    }

}
