package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

public class RequeteSelectFactureById extends Requete<Facture> {

	/**
	 * Retourne la requête SQL. Sélectionne une facture par son numéro.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Facture where Numero_Facture = ?";
	}

	/**
	 * Définit le paramètre de la requête.
	 * 
	 * @param id numéro de la facture
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
