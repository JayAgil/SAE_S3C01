package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.IRL;

/**
 * Requête permettant de supprimer une valeur IRL de la base de données
 * à partir de l'année et du trimestre.
 */
public class RequeteDeleteIRL extends Requete<IRL>{
	
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_IRL where Annee = ? and Trimestre = ?";
	}
	
	@Override
	public void parametres(PreparedStatement ps, IRL irl) throws SQLException {
		ps.setDouble(1, irl.getAnnee());
		ps.setInt(2, irl.getTrimestre());

	}
}
