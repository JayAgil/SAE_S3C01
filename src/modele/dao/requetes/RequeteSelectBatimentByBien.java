package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

/**
 * Requête permettant de récupérer le bâtiment associé à un bien louable donné.
 * La récupération se fait à partir de l'identifiant du bien louable.
 */
public class RequeteSelectBatimentByBien extends Requete<Batiment> {

	/**
	 * Fournit la requête SQL pour récupérer l'adresse et la date de construction du
	 * bâtiment correspondant à un bien louable spécifique.
	 *
	 * @return la requête SQL SELECT avec jointure sur le bien louable
	 */
	@Override
	public String requete() {
		return "SELECT b.Adresse, b.Date_construction " + "FROM MSF5131A.SAE_Batiment b "
				+ "JOIN MSF5131A.SAE_BienLouable bl ON bl.fk_Adresse_Bat = b.Adresse " + "WHERE bl.Id_BienLouable = ?";

	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant du bien louable.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   l'identifiant du bien louable (id[0])
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
