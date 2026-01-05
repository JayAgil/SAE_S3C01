package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.IRL;

public class RequeteSelectIRLById extends Requete<IRL> {

    @Override
    public String requete() {
        return "SELECT * FROM MSF5131A.SAE_IRL WHERE annee = ? AND trimestre = ?";
    }
    
    public void parametres(PreparedStatement prSt, String... keys) throws SQLException {
        prSt.setInt(1, Integer.parseInt(keys[0])); 
        prSt.setInt(2, Integer.parseInt(keys[1])); 
    }
}
