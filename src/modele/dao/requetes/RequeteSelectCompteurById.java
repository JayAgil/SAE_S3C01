package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Compteur;

/**
 * Requête permettant de récupérer un compteur spécifique à partir de son
 * identifiant. Les résultats sont triés par l'index nouveau dans l'ordre
 * décroissant.
 */
public class RequeteSelectCompteurById extends Requete<Compteur> {

	/**
	 * Fournit la requête SQL pour récupérer un compteur à partir de son
	 * identifiant.
	 *
	 * @return la requête SQL SELECT avec condition sur l'identifiant du compteur
	 */
	@Override
	public String requete() {
		return "Select * from MSF5131A.SAE_Compteur where Id_Compteur = ? Order by Index_nouveau DESC";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant du compteur.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant l'identifiant du compteur en première
	 *             position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
