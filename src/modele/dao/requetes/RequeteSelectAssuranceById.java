package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

/**
 * Requête permettant de sélectionner une assurance spécifique à partir de son
 * numéro.
 */
public class RequeteSelectAssuranceById extends Requete<Assurance> {
	/**
	 * Fournit la requête SQL pour récupérer une assurance en fonction de son
	 * numéro.
	 *
	 * @return la requête SQL SELECT avec condition sur le numéro de l'assurance
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_ASSURANCE where Numero_d_assurance = ? ";

	}

	/**
	 * Renseigne le paramètre de la requête SQL avec le numéro de l'assurance.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant le numéro de l'assurance à utiliser pour
	 *             filtrer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
