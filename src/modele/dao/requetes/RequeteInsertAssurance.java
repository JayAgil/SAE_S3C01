package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteInsertAssurance extends Requete<Assurance> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_ASSURANCE VALUES (?,?,?, ?, ?, ?, ?, ?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Assurance a) throws SQLException {
        ps.setString(1, a.getNumeroAssurance());
        ps.setDouble(2, a.getPrime());
        ps.setDouble(3, a.getMontant());
        ps.setString(4, a.getTypeAssurance());
        ps.setString(5, a.getAgence());
        ps.setString(6, a.getAdresseAgence());
        ps.setString(7, a.getTelAgence());
        ps.setString(8, a.getBatiment().getAdresse());
    }

	
}
