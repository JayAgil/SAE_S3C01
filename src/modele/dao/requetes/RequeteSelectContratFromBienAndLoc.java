package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ContratLocation;

/**
 * Requête permettant de récupérer les contrats de location
 * pour un locataire spécifique et un bien louable donné.
 * Les résultats sont triés par date de début décroissante.
 */
public class RequeteSelectContratFromBienAndLoc extends Requete<ContratLocation>{

	/**
     * Fournit la requête SQL pour récupérer les contrats de location
     * à partir de l'identifiant du locataire et de l'identifiant du bien louable.
     *
     * @return la requête SQL SELECT avec conditions sur le locataire et le bien louable
     */
    @Override
	public String requete() {
		return "SELECT cl.* "
				+ "FROM MSF5131A.SAE_ContratLocation cl "
				+ "JOIN MSF5131A.SAE_Contrat_Locataire cll "
				+ "ON cll.Numero_de_contrat = cl.Numero_de_contrat "
				+ "WHERE cll.Id_Locataire = ? "
				+ "AND cl.fk_Id_BienLouable = ? "
				+ "Order by Date_debut DESC";
	}

    /**
     * Renseigne les paramètres de la requête SQL avec l'identifiant du locataire
     * et l'identifiant du bien louable.
     *
     * @param prSt le PreparedStatement à compléter
     * @param id   tableau contenant en première position l'identifiant du locataire
     *             et en deuxième position l'identifiant du bien louable
     * @throws SQLException si une erreur SQL survient
     */
    @Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
	}

}
