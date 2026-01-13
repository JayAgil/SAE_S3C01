package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

public class RequeteSelectFactureByBien extends Requete<Facture> {

	/**
	 * Retourne la requête SQL. Sélectionne les factures d’un bien louable donné.
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Facture where fk_Id_BienLouable = ?";
	}

	/**
	 * Définit le paramètre de la requête.
	 * 
	 * @param id identifiant du bien louable
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
