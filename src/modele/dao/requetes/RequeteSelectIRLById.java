package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.IRL;

public class RequeteSelectIRLById extends Requete<IRL> {

    @Override
    public String requete() {
        // Now the query uses two parameters: annee and trimestre (for example)
        return "SELECT * FROM MSF5131A.SAE_IRL WHERE annee = ? AND trimestre = ?";
    }
    
    public void parametres(PreparedStatement prSt, String... keys) throws SQLException {
        if (keys.length < 2) {
            throw new IllegalArgumentException("Two parameters required: year and trimester");
        }
        
        // Assuming both columns are integers
        prSt.setInt(1, Integer.parseInt(keys[0])); // annee
        prSt.setInt(2, Integer.parseInt(keys[1])); // trimestre
    }
}
