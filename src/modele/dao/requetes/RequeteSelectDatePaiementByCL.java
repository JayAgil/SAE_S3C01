package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;
import modele.Paiement;

public class RequeteSelectDatePaiementByCL extends Requete<Paiement> {

	/**
	 * Retourne la requête SQL. Sélectionne tous les paiements liés à un contrat
	 * grâce à la clé étrangère fk_Numero_de_contrat, triés par date de paiement
	 * décroissante.
	 */
	public String requete() {
		return " Select * from MSF5131A.SAE_Paiement where fk_Numero_de_contrat = ? order by Date_Paiement DESC";
	}

	/**
	 * Associe le paramètre de la requête SQL.
	 * 
	 * @param prSt PreparedStatement à paramétrer
	 * @param id   identifiant du contrat de location
	 */
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	public void parametres(PreparedStatement prSt, ContratLocation donnee) {

	}

}
