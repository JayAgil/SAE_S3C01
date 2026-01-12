package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

/**
 * Requête permettant d'insérer un diagnostic dans la base de données.
 * Chaque diagnostic est associé à un bien louable.
 */
public class RequeteInsertDiagnostics extends Requete<Diagnostics> {
	
	 /**
     * Fournit la requête SQL d'insertion d'un diagnostic.
     *
     * @return la requête SQL INSERT
     */
	@Override
	public String requete() {
		return "INSERT INTO MSF5131A.SAE_Diagnostics VALUES (?,?,?,?,?,?)";
	}
	
	 /**
     * Renseigne les paramètres de la requête SQL avec les informations du diagnostic.
     *
     * @param ps le PreparedStatement à compléter
     * @param d  le diagnostic à insérer
     * @throws SQLException si une erreur SQL survient
     */
	@Override
    public void parametres(PreparedStatement ps, Diagnostics d) throws SQLException {
        ps.setString(1, d.getIdDiagnostics());
        ps.setString(2, d.getTypeDiagnostics());
        ps.setDate(3, d.getDateRealisation());
        ps.setDate(4, d.getDateValidite());
        ps.setString(5, d.getFichier());
        ps.setString(6, d.getBienLouable().getIdBienLouable());
    }

}
