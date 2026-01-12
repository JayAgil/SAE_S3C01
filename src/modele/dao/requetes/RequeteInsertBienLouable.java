package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

/**
 * Requête permettant d'insérer un bien louable dans la base de données. Tous
 * les champs du bien louable sont insérés, y compris l'éventuel logement parent
 * et le bâtiment associé.
 */
public class RequeteInsertBienLouable extends Requete<BienLouable> {

	/**
	 * Fournit la requête SQL d'insertion pour la table SAE_BienLouable.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "INSERT INTO MSF5131A.SAE_BienLouable VALUES (?,?,?,?,?,?,?,?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les données du bien louable.
	 * Si le bien a un logement parent, son identifiant est inséré ; sinon, la
	 * valeur NULL est utilisée.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param b  le bien louable à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, BienLouable b) throws SQLException {
		ps.setString(1, b.getIdBienLouable());
		ps.setString(2, b.getNumeroFiscale());
		ps.setString(3, b.getAdresse());
		ps.setDouble(4, b.getSurfaceHabituable());
		ps.setInt(5, b.getNbPieces());
		ps.setString(6, b.getTypeBienLouable());
		if (b.getLogement() != null) {
			ps.setString(7, b.getLogement().getIdBienLouable());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}
		ps.setString(8, b.getBatiment().getAdresse());

	}

}
