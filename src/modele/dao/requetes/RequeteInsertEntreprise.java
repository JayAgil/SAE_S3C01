package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

public class RequeteInsertEntreprise extends Requete<Entreprise> {
	
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Entreprise VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Entreprise e) throws SQLException {
        ps.setString(1, e.getNumSiret());
        ps.setString(2, e.getAdresse());
        ps.setString(3, e.getVille());
        ps.setString(4, e.getCodePostal());
        ps.setString(5, e.getNom());
        ps.setString(6, e.getNumTel());
        ps.setString(7, e.getSpecialite());
    }

}
