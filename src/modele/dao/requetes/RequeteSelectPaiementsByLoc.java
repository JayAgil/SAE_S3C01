package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Paiement;

public class RequeteSelectPaiementsByLoc extends Requete<Paiement> {

    @Override
    public String requete() {
        return """
            SELECT p.*
            FROM MSF5131A.SAE_Paiement p
            JOIN MSF5131A.SAE_ContratLocation c
                ON p.fk_Numero_de_contrat = c.Numero_de_contrat
            JOIN MSF5131A.SAE_Contrat_Locataire cl
                ON c.Numero_de_contrat = cl.Numero_de_contrat
            WHERE cl.Id_Locataire = ?
        """;
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); 
    }
}