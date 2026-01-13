package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Compteur;

public class RequeteUpdateCompteur extends Requete<Compteur> {

	/**
	 * Retourne la requête SQL pour mettre à jour un compteur. Les champs mis à jour
	 * sont : partie fixe, partie variable, total, type de compteur, date
	 * d'installation, index ancien et index nouveau.
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "Update MSF5131A.SAE_Compteur " + "SET Partie_Fixe = ?, Partie_Variable = ?, "
				+ "Total = ?, TypeCompteur = ?, " + "Date_Installation = ?, Index_ancien = ?, " + "Index_nouveau = ? "
				+ "Where Id_Compteur = ? ";
	}

	/**
	 * Paramètre le PreparedStatement avec les valeurs de l'objet Compteur fourni.
	 * L'ordre des paramètres doit correspondre exactement à celui de la requête
	 * SQL.
	 *
	 * @param prSt   PreparedStatement à paramétrer
	 * @param donnee Compteur contenant les nouvelles valeurs
	 * @throws SQLException en cas d'erreur SQL
	 */
	@Override
	public void parametres(PreparedStatement prSt, Compteur donnee) throws SQLException {
		prSt.setDouble(1, donnee.getPartieFixe());
		prSt.setDouble(2, donnee.getPartieVariable());
		prSt.setDouble(3, donnee.getTotal());
		prSt.setString(4, donnee.getType());
		prSt.setDate(5, donnee.getDateInstallation());
		prSt.setDouble(6, donnee.getIndexAncien());
		prSt.setDouble(7, donnee.getIndexNouveau());
		prSt.setString(8, donnee.getIdCompteur());
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

}
