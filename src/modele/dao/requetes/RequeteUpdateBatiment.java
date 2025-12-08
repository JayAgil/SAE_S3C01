package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

public class RequeteUpdateBatiment extends Requete<Batiment> {
    @Override
    public String requete() {
        return " Update SAE_BATIMENT set DATE_CONSTRUCTION =  ? Where ADRESSE = ? ";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Batiment donnee)
        throws SQLException {
        prSt.setString(1, donnee.getDateConstruction().toString());
        prSt.setString(2, donnee.getAdresse());
    }

}
