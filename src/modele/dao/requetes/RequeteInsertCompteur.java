package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Compteur;

public class RequeteInsertCompteur extends Requete<Compteur> {
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Compteur VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
    public void parametres(PreparedStatement ps, Compteur c) throws SQLException {
        ps.setString(1, c.getIdCompteur());
        ps.setDouble(2, c.getPartieFixe());
        ps.setDouble(3, c.getPartieVariable());
        ps.setDouble(4, c.getTotal());
        ps.setString(5, c.getType());
        ps.setDate(6, c.getDateInstallation());
        ps.setDouble(7, c.getIndexAncien());
        ps.setDouble(8, c.getIndexNouveau());
        ps.setString(9, c.getBienLouable().getIdBienLouable());
    }

}
