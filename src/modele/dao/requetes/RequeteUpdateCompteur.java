package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Compteur;

public class RequeteUpdateCompteur extends Requete<Compteur> {
	
	@Override
    public String requete() {
        return "Update MSF5131A.SAE_Compteur"
        		+ "set Date_debut = ?,"
        		+ "Partie_Fixe = ?, Partie_Variable = ?,"
        		+ "Total = ?, TypeCompteur = ?,"
        		+ "Date_Installation = ?, Index_ancien = ?,"
        		+ "Index_nouveau = ?"
        		+ "Where Id_Compteur = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Compteur donnee)
        throws SQLException {
        prSt.setDouble(1, donnee.getPartieFixe());
        prSt.setDouble(2, donnee.getPartieVariable());
        prSt.setDouble(3, donnee.getTotal());
        prSt.setString(4, donnee.getType());
        prSt.setDate(5, donnee.getDateInstallation());
        prSt.setDouble(6, donnee.getIndexAncien());
        prSt.setDouble(7, donnee.getIndexNouveau());
    }


}
