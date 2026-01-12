package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.BienLouable;

/**
 * Requête permettant de récupérer un bien louable à partir de son identifiant.
 */
public class RequeteSelectBienLouableById extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL pour récupérer un bien louable selon son identifiant.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_BienLouable where Id_BienLouable = ? ";

	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant du bien
	 * louable.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   tableau contenant l'identifiant du bien louable en première
	 *             position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
