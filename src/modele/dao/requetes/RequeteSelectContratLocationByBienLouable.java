package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteSelectContratLocationByBienLouable
    extends Requete<ContratLocation> {
    @Override
    public String requete() {
        return " Select * from MSF5131A.SAE_ContratLocation where FK_ID_BIENLOUABLE = ? Order by Date_debut DESC";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, ContratLocation donnee) {

    }

}
