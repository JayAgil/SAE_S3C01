package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Locataire;

/**
 * Requête permettant de supprimer un locataire de la base de données
 * à partir de son Id_Locataire.
 */
public class RequeteDeleteLocataire extends Requete<Locataire>{

	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_LOCATAIRE where Id_Locataire = ?";
	}
	
	@Override
	public void parametres(PreparedStatement ps, Locataire l) throws SQLException {
		ps.setString(1, l.getIdLocataire());

	}
}
