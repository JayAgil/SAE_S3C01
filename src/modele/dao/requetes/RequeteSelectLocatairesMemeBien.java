package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectLocatairesMemeBien extends Requete<Locataire> {

    @Override
    public String requete() {
        return """
            SELECT DISTINCT l2.*
            FROM MSF5131A.SAE_Locataire l2
            JOIN MSF5131A.SAE_Contrat_Locataire cl2
                ON l2.Id_Locataire = cl2.Id_Locataire
            JOIN MSF5131A.SAE_ContratLocation c2
                ON cl2.Numero_de_contrat = c2.Numero_de_contrat
            WHERE c2.fk_Id_BienLouable = (
                SELECT c1.fk_Id_BienLouable
                FROM MSF5131A.SAE_Contrat_Locataire cl1
                JOIN MSF5131A.SAE_ContratLocation c1
                    ON cl1.Numero_de_contrat = c1.Numero_de_contrat
                WHERE cl1.Id_Locataire = ?
            )
        """;
    }

    @Override
    public void parametres(PreparedStatement prSt, String... params) throws SQLException {
        prSt.setString(1, params[0]); 
    }
}
