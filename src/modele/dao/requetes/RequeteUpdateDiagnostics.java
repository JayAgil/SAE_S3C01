package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteUpdateDiagnostics extends Requete<Diagnostics> {

	/**
	 * Retourne la requête SQL pour mettre à jour un diagnostic. Les champs mis à
	 * jour sont : - Type de diagnostic - Date de réalisation - Date de validité -
	 * Fichier associé
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return "Update MSF5131A.SAE_Diagnostics " + "set Type_Diagnostic = ?,"
				+ "Date_Realisation  = ?, Date_Validite  = ?, " + "Fichier = ? " + "Where Id_Diagnostics = ?";

	}

	/**
	 * Paramètre le PreparedStatement avec les valeurs d'un objet Diagnostics.
	 * L'ordre des paramètres correspond exactement à celui de la requête SQL.
	 *
	 * @param prSt   PreparedStatement à paramétrer
	 * @param donnee Diagnostics contenant les nouvelles valeurs
	 * @throws SQLException en cas d'erreur SQL
	 */
	@Override
	public void parametres(PreparedStatement prSt, Diagnostics donnee) throws SQLException {
		prSt.setString(1, donnee.getTypeDiagnostics());
		prSt.setDate(2, donnee.getDateRealisation());
		prSt.setDate(3, donnee.getDateValidite());
		prSt.setString(4, donnee.getFichier());
		prSt.setString(5, donnee.getIdDiagnostics());
	}

}
