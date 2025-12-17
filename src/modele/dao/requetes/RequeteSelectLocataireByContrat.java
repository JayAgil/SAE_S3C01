package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectLocataireByContrat extends Requete<Locataire> {

    @Override
    public String requete() {
        return "SELECT * "
             + "FROM MSF5131A.SAE_LOCATAIRE "
             + "WHERE Id_locataire IN ( "
             + "    SELECT Id_locataire "
             + "    FROM MSF5131A.SAE_CONTRAT_LOCATAIRE "
             + "    WHERE Numero_de_contrat = ? "
             + ")";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Locataire donnee) {

    }

}
