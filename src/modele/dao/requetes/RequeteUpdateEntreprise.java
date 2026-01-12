package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

public class RequeteUpdateEntreprise extends Requete<Entreprise> {

	/**
	 * Retourne la requête SQL UPDATE pour mettre à jour une entreprise. Les
	 * paramètres à renseigner dans le PreparedStatement sont :
	 */
	@Override
	public String requete() {
		return "Update MSF5131A.SAE_Entreprise set Adresse = ?," + "Ville = ?, Code_Postale = ?,"
				+ "Nom = ?, Numero_de_Telephone = ?" + "Specialite = ?" + "Where Numero_Siret = ?";

	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	/**
	 * Méthode parametres pour un objet Entreprise. Remplit le PreparedStatement
	 * avec les valeurs provenant de l'objet Entreprise.
	 * 
	 * @param prSt   PreparedStatement sur lequel on définit les paramètres
	 * @param donnee Objet Entreprise contenant les valeurs à mettre à jour
	 */
	@Override
	public void parametres(PreparedStatement prSt, Entreprise donnee) throws SQLException {
		prSt.setString(1, donnee.getAdresse());
		prSt.setString(2, donnee.getVille());
		prSt.setString(3, donnee.getCodePostal());
		prSt.setString(4, donnee.getNom());
		prSt.setString(5, donnee.getNumTel());
		prSt.setString(6, donnee.getSpecialite());
		prSt.setString(6, donnee.getNumSiret());
	}

}
