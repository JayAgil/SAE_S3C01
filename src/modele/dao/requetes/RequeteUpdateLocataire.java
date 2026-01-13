package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteUpdateLocataire extends Requete<Locataire> {

	/**
	 * Retourne la requête SQL UPDATE pour mettre à jour un locataire.
	 */
	@Override
	public String requete() {
		return " Update MSF5131A.SAE_Locataire set Tel = ?,EMAIL = ?, ADRESSE =  ?, "
				+ "CODE_POSTAL =  ?, VILLE = ?, SALAIRE = ?, PROFESSION = ?,"
				+ "SITUATION_FAMILIALE = ? Where ID_Locataire = ? ";

	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	/**
	 * Méthode parametres pour un objet Locataire. Remplit le PreparedStatement avec
	 * les valeurs provenant de l'objet Locataire.
	 * 
	 * @param prSt   PreparedStatement sur lequel on définit les paramètres
	 * @param donnee Objet Locataire contenant les valeurs à mettre à jour
	 */
	@Override
	public void parametres(PreparedStatement prSt, Locataire donnee) throws SQLException {
		prSt.setString(1, donnee.getTel());
		prSt.setString(2, donnee.getEmail());
		prSt.setString(3, donnee.getAdresse());
		prSt.setString(4, donnee.getCodePostale());
		prSt.setString(5, donnee.getVille());
		prSt.setDouble(6, donnee.getSalaire());
		prSt.setString(7, donnee.getProfession());
		prSt.setString(8, donnee.getSituationFamiliale());
		prSt.setString(9, donnee.getIdLocataire());
	}

}
