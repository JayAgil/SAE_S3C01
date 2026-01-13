package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Paiement;

public class RequeteSelectPaiementsByLoc extends Requete<Paiement> {

	/**
	 * Retourne la requête SQL pour récupérer les paiements liés à un locataire
	 * donné. La requête fait la jointure entre Paiement, ContratLocation et
	 * Contrat_Locataire pour retrouver tous les paiements correspondant au
	 * locataire.
	 *
	 * @return String contenant la requête SQL
	 */
	@Override
	public String requete() {
		return """
				    SELECT p.*
				    FROM MSF5131A.SAE_Paiement p
				    JOIN MSF5131A.SAE_ContratLocation c
				        ON p.fk_Numero_de_contrat = c.Numero_de_contrat
				    JOIN MSF5131A.SAE_Contrat_Locataire cl
				        ON c.Numero_de_contrat = cl.Numero_de_contrat
				    WHERE cl.Id_Locataire = ?
				    ORDER BY p.Date_Paiement DESC
				""";
	}

	/**
	 * Définit le paramètre de la requête préparée. Ici, on remplace le premier
	 * paramètre par l'identifiant du locataire.
	 *
	 * @param prSt PreparedStatement à paramétrer
	 * @param id   Tableau contenant l'identifiant du locataire
	 * @throws SQLException en cas d'erreur SQL
	 */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}