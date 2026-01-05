package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteInsertContratLocataire extends Requete<Void> {

    @Override
    public String requete() {
        return "INSERT INTO MSF5131A.SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat) VALUES (?, ?)";
    }

    public void parametres(PreparedStatement ps, String idLocataire, String numeroContrat) throws SQLException {
        ps.setString(1, idLocataire);
        ps.setString(2, numeroContrat);
    }
}
