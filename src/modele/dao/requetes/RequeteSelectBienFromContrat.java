package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

/**
 * Requête permettant de récupérer le bien louable associé à un contrat de
 * location spécifique.
 */
public class RequeteSelectBienFromContrat extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL pour récupérer le bien louable correspondant à un
	 * contrat donné.
	 *
	 * @return la requête SQL SELECT avec jointure sur la table des contrats
	 */
	@Override
	public String requete() {
		return "SELECT b.Id_BienLouable, b.NumeroFiscale, b.Adresse, b.Surface_d_habituable, "
				+ "b.Nombre_de_pieces, b.Type_bien_louable, b.Id_BienLouable_2, b.fk_Adresse_Bat "
				+ "FROM MSF5131A.SAE_BienLouable b "
				+ "JOIN MSF5131A.SAE_ContratLocation c ON b.Id_BienLouable = c.fk_Id_BienLouable "
				+ "WHERE c.Numero_de_Contrat = ?";
	}

	/**
	 * Renseigne le paramètre de la requête SQL avec l'identifiant du contrat de
	 * location.
	 *
	 * @param prSt le PreparedStatement à compléter
	 * @param id   l'identifiant du contrat de location (id[0])
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

}
