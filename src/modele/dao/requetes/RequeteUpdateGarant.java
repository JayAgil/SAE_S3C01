package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Garant;

public class RequeteUpdateGarant extends Requete<Garant> {
    @Override
    public String requete() {
        return " Update MSF5131A.SAE_Garant"
        		+ "set Nom = ?, "
        		+ "Prenom =  ?, Adresse =  ?,"
        		+ "Tel = ?"
        		+ "Where ID_GARANT = ?";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Garant donnee)
        throws SQLException {
        prSt.setString(1, donnee.getNom());
        prSt.setString(2, donnee.getPrenom());
        prSt.setString(3, donnee.getAdresse());
        prSt.setString(4, donnee.getTel());
    }

}
