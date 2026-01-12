package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;

/**
 * Requête permettant d'insérer une facture dans la base de données.
 */
public class RequeteInsertFacture extends Requete<Facture> {

	/**
	 * Fournit la requête SQL d'insertion d'une facture.
	 *
	 * @return la requête SQL INSERT
	 */
	@Override
	public String requete() {
		return """
				INSERT INTO MSF5131A.SAE_Facture (
				    Numero_Facture,
				    Montant,
				    Date_de_facture,
				    Compte_Bancaire,
				    Montant_Devis,
				    Date_Paiement,
				    Designation_de_travaux,
				    fk_Id_BienLouable,
				    fk_Numero_Siret
				) VALUES (?,?,?,?,?,?,?,?,?)
				""";
	}

	/**
	 * Renseigne les paramètres de la requête SQL avec les informations de la
	 * facture.
	 *
	 * @param ps le PreparedStatement à compléter
	 * @param f  la facture à insérer
	 * @throws SQLException si une erreur SQL survient
	 */
	@Override
	public void parametres(PreparedStatement ps, Facture f) throws SQLException {
		ps.setString(1, f.getNumeroFacture());
		ps.setDouble(2, f.getMontant());
		ps.setDate(3, f.getDateDeFacture());
		ps.setString(4, f.getCompteBancaire());
		ps.setDouble(5, f.getMontantDevis());
		ps.setDate(6, f.getDatePaiement());
		ps.setString(7, f.getDesignationDeTravaux());
		ps.setString(8, f.getBienLoauble().getIdBienLouable());
		ps.setString(9, f.getEntreprise().getNumSiret());
	}

}
