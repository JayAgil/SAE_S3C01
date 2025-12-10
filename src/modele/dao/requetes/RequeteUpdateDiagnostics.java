package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteUpdateDiagnostics extends Requete<Diagnostics> {
	
	@Override
    public String requete() {
        return "Update MSF5131A.SAE_Diagnostics "
        		+ "set Type_Diagnostic = ?,"
        		+ "Date_Realisation  = ?, Date_Validite  = ?,"
        		+ "Fichier = ?"
        		+ "Where Id_Diagnostics = ?";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Diagnostics donnee)
        throws SQLException {
        prSt.setString(1, donnee.getTypeDiagnostics());
        prSt.setDate(2, donnee.getDateRealisation());
        prSt.setDate(3, donnee.getDateValidite());
        prSt.setString(4, donnee.getFichier());
    }

}
