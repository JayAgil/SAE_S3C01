package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ChargesGenerales;

/**
 * Requête permettant de récupérer une charge générale spécifique à partir de
 * son identifiant. Le résultat est trié par date de charge.
 */
public class RequeteSelectChargesGeneralesById extends Requete<ChargesGenerales> {

	/**
	 * Fournit la requête SQL pour récupérer la charge générale correspondant à
	 * l'identifiant fourni.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_Charges_Generale where Id_Charges_Generale = ? Order by Date_Charge";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant de la charge
	 * générale.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   tableau contenant l'identifiant (id[0])
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
