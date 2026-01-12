package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.BienLouable;

public class RequeteUpdateBienLouable extends Requete<BienLouable> {

	/**
	 * Retourne la requête SQL pour mettre à jour un bien louable. Les champs mis à
	 * jour sont : numéro fiscal, adresse, surface, nombre de pièces, type de bien,
	 * bien lié (logement) et adresse du bâtiment associé.
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "UPDATE MSF5131A.SAE_BienLouable SET " + "NumeroFiscale = ?, " + "Adresse = ?, "
				+ "Surface_d_habituable = ?, " + "Nombre_de_pieces = ?, " + "Type_bien_louable = ?, "
				+ "Id_BienLouable_2 = ?, " + "fk_Adresse_Bat = ? " + "WHERE Id_BienLouable = ?";
	}

	/**
	 * Paramètre le PreparedStatement avec les valeurs de l'objet BienLouable
	 * fourni. L'ordre des paramètres doit correspondre exactement à celui de la
	 * requête SQL.
	 *
	 * @param ps PreparedStatement à paramétrer
	 * @param b  BienLouable contenant les nouvelles valeurs
	 * @throws SQLException en cas d'erreur SQL
	 */
	@Override
	public void parametres(PreparedStatement ps, BienLouable b) throws SQLException {

		ps.setString(1, b.getNumeroFiscale());
		ps.setString(2, b.getAdresse());
		ps.setDouble(3, b.getSurfaceHabituable());
		ps.setInt(4, b.getNbPieces());
		ps.setString(5, b.getTypeBienLouable());
		ps.setString(6, b.getLogement().getIdBienLouable());
		ps.setString(7, b.getBatiment().getAdresse());
		ps.setString(8, b.getIdBienLouable());

	}

}
