package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

/**
 * Requête permettant d'insérer un locataire dans la base de données.
 */
public class RequeteInsertLocataire extends Requete<Locataire> {

	/**
	 * Fournit la requête SQL d'insertion d'un locataire.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_LOCATAIRE ("
				+ "Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, "
				+ "Date_de_naissance, Lieu_de_naissance, Salaire, Profession, Situation_Familiale, " + "fk_Id_Garant) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations du
	 * locataire.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param l  le locataire à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Locataire l) throws SQLException {

		ps.setString(1, l.getIdLocataire());
		ps.setString(2, l.getNom());
		ps.setString(3, l.getPrenom());
		ps.setString(4, l.getAdresse());
		ps.setString(5, l.getTel());
		ps.setString(6, l.getEmail());
		ps.setString(7, l.getCodePostale());
		ps.setString(8, l.getVille());
		ps.setDate(9, l.getDateDeNaissance());
		ps.setString(10, l.getLieuDeNaissance());
		ps.setDouble(11, l.getSalaire());
		ps.setString(12, l.getProfession());
		ps.setString(13, l.getSituationFamiliale());
		if (l.getGarant() != null)
			ps.setString(14, l.getGarant().getIdGarant());
		else
			ps.setNull(14, java.sql.Types.VARCHAR);
	}
}
