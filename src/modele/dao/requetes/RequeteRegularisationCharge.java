package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

public class RequeteRegularisationCharge extends Requete<ContratLocation> {

    @Override
    public String requete() {
        return "SELECT  MSF5131A.calcul_regularisation_contrat( ?, ?) AS solde FROM dual";
    }

    public void parametres(PreparedStatement ps, ContratLocation c, int annee)
        throws SQLException {
        ps.setInt(1, annee);
        ps.setString(2, c.getNumeroDeContrat());
    }

}
