package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Facture;

/**
 * Requête permettant de récupérer toutes les factures associées à un bien
 * louable spécifique, triées par date de facture décroissante.
 */
public class RequeteSelectDateFactureByBien extends Requete<Facture> {

	/**
	 * Fournit la requête SQL pour récupérer les factures d'un bien louable donné.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		return " Select * from MSF5131A.SAE_Facture where fk_Id_BienLouable = ? Order by Date_de_facture DESC";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant du bien louable.
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
