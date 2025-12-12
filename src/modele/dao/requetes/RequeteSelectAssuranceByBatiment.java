package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteSelectAssuranceByBatiment extends Requete<Assurance> {

    @Override
    public String requete() {
        return "SELECT Numero_d_assurance, Prime, Montant, Type_assurance, "
             + "Agence, Adresse_agence, Tel_agence "
             + "FROM MSF5131A.SAE_ASSURANCE "
             + "WHERE fk_Adresse_Bat = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }
}
