package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;

public class RequeteUpdateEntreprise extends Requete<Entreprise> {
	
	@Override
    public String requete() {
        return "Update MSF5131A.SAE_Entreprise set Adresse = ?,"
        		+ "Ville = ?, Code_Postale = ?,"
        		+ "Nom = ?, Numero_de_Telephone = ?"
        		+ "Specialite = ?"
        		+ "Where Numero_Siret = ?";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Entreprise donnee)
        throws SQLException {
        prSt.setString(1, donnee.getAdresse());
        prSt.setString(2, donnee.getVille());
        prSt.setString(3, donnee.getCodePostal());
        prSt.setString(4, donnee.getNom());
        prSt.setString(5, donnee.getNumTel());
        prSt.setString(6, donnee.getSpecialite());
        
    }


}
