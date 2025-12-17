package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteSelectAssuranceByBatiment extends Requete<Assurance> {

    @Override
    public String requete() {
        return "SELECT * "
             + "FROM MSF5131A.SAE_ASSURANCE "
             + "WHERE fk_Adresse_Bat = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }
}
