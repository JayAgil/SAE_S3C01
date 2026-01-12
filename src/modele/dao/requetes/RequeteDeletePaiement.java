package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Paiement;

/**
 * Requête permettant de supprimer un paiement de la base de données
 * à partir de son Id_Paiement.
 */
public class RequeteDeletePaiement extends Requete<Paiement>{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_PAIEMENT where Id_Paiement = ?";
	}
	
	@Override
	public void parametres(PreparedStatement ps, Paiement p) throws SQLException {
		ps.setString(1, p.getId_paiement());

	}
}
