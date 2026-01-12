package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Compteur;

/**
 * Requête permettant de récupérer tous les compteurs associés à un bien louable
 * donné. Les résultats sont triés par l'index nouveau dans l'ordre décroissant.
 */
public class RequeteSelectCompteurByBien extends Requete<Compteur> {

	/**
	 * Fournit la requête SQL pour récupérer les compteurs d'un bien louable
	 * spécifique.
	 *
	 * @return la requête SQL SELECT avec condition sur le bien louable
	 */
	@Override
	public String requete() {
		return "SELECT * FROM MSF5131A.SAE_Compteur WHERE fk_Id_BienLouable = ? Order by Index_nouveau DESC";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec l'identifiant du bien
	 * louable.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   le tableau contenant l'identifiant du bien louable en première
	 *             position
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
