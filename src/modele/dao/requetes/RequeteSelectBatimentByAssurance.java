package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

/**
 * Requête permettant de récupérer le bâtiment associé à une assurance donnée.
 * La récupération se fait en fonction du numéro d'assurance.
 */
public class RequeteSelectBatimentByAssurance extends Requete<Batiment>{
	
	/**
     * Fournit la requête SQL pour récupérer le bâtiment correspondant
     * à un numéro d'assurance spécifique.
     *
     * @return la requête SQL SELECT avec jointure sur l'assurance
     */
	@Override
	public String requete() {
		return " SELECT b.* "
				+ "FROM MSF5131A.SAE_Batiment b "
				+ "JOIN MSF5131A.SAE_Assurance a "
				+ "ON a.fk_Adresse = b.Adresse "
				+ "WHERE a.Numero_d_assurance = ? ";
		
	}

	/**
     * Renseigne le paramètre de la requête SQL avec le numéro d'assurance.
     *
     * @param prSt le PreparedStatement à compléter
     * @param id   le numéro d'assurance (id[0])
     * @throws SQLException si une erreur SQL survient
     */
    @Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
}
