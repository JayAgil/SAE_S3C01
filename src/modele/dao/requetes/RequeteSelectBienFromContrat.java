package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteSelectBienFromContrat extends Requete<BienLouable>{

	@Override
	public String requete() {
	    return "SELECT b.Id_BienLouable, b.NumeroFiscale, b.Adresse, b.Surface_d_habituable, " +
	           "b.Nombre_de_pieces, b.Type_bien_louable, b.Id_BienLouable_2, b.fk_Adresse_Bat " +
	           "FROM MSF5131A.SAE_BienLouable b " +
	           "JOIN MSF5131A.SAE_ContratLocation c ON b.Id_BienLouable = c.fk_Id_BienLouable " +
	           "WHERE c.Numero_de_Contrat = ?";
	}

	
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
