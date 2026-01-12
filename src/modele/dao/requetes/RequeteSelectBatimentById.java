package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Batiment;

/**
 * Requête permettant de récupérer un bâtiment à partir de son adresse.
 */
public class RequeteSelectBatimentById extends Requete<Batiment> {
	
	/**
     * Fournit la requête SQL pour récupérer un bâtiment selon son adresse.
     *
     * @return la requête SQL SELECT avec condition sur l'adresse
     */
    @Override
	public String requete() {
		return " Select * from MSF5131A.SAE_Batiment where Adresse = ? " ;
		
	}

    /**
     * Renseigne le paramètre de la requête SQL avec l'adresse du bâtiment.
     *
     * @param prSt le PreparedStatement à compléter
     * @param id   l'adresse du bâtiment (id[0])
     * @throws SQLException si une erreur SQL survient
     */
    @Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}


}
