package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Batiment;

public class RequeteUpdateBatiment extends Requete<Batiment> {
    
	/**
     * Retourne la requête SQL pour mettre à jour la date de construction d'un bâtiment.
     *
     * @return String contenant la requête SQL
     */
	@Override
    public String requete() {
        return " Update MSF5131A.SAE_Batiment set DATE_CONSTRUCTION =  ? Where ADRESSE = ? ";

    }
	
	/**
     * Paramètre le PreparedStatement avec les valeurs de l'objet Batiment fourni.
     * L'ordre des paramètres correspond à celui défini dans la requête SQL.
     *
     * @param prSt   PreparedStatement à paramétrer
     * @param donnee Batiment contenant les nouvelles valeurs
     * @throws SQLException en cas d'erreur SQL
     */
    @Override
    public void parametres(PreparedStatement prSt, Batiment donnee)
        throws SQLException {
        prSt.setString(1, donnee.getDateConstruction().toString());
        prSt.setString(2, donnee.getAdresse());
    }

}
