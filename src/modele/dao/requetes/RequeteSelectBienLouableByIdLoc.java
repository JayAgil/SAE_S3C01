package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienLouableByIdLoc extends Requete<BienLouable> {
	public String requete() {
		return """
		        SELECT *
		        FROM MSF5131A.SAE_BienLouable bl
		        JOIN MSF5131A.SAE_ContratLocation cl
		            ON bl.Id_BienLouable = cl.fk_Id_BienLouable
		        JOIN MSF5131A.SAE_Contrat_Locataire cll
		            ON cl.Numero_de_contrat = cll.Numero_de_contrat
		        WHERE cll.Id_Locataire = ?
		        """;
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
