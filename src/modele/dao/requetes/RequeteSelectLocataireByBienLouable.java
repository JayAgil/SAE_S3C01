package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectLocataireByBienLouable extends Requete<Locataire> {

	@Override
	public String requete() {
		return  "SELECT L.* " +
		        "FROM SAE_Locataire L " +
		        "JOIN SAE_Contrat_Locataire CL ON L.Id_Locataire = CL.Id_Locataire " +
		        "JOIN SAE_ContratLocation C ON C.Numero_de_contrat = CL.Numero_de_contrat " +
		        "WHERE C.fk_Id_BienLouable = ?";
	}

	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
