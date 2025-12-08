package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;
import modele.Garant;
import modele.Locataire;

public class RequeteUpdateLocataire extends Requete<Locataire> {
    @Override
    public String requete() {
        return " Update MSF5131A.SAE_Locataire set Tel = ?,EMAIL = ?, ADRESSE =  ?, "
        		+ "CODE_POSTAL =  ?, VILLE = ?, SALAIRE = ?, PROFESSION = ?,"
        		+ "SITUATION_FAMILIALE = ? Where ID_Locataire = ? ";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Locataire donnee)
        throws SQLException {
        prSt.setString(1, donnee.getTel());
        prSt.setString(2, donnee.getEmail());
        prSt.setString(3, donnee.getAdresse());
        prSt.setString(4, donnee.getCodePostale());
        prSt.setString(5, donnee.getVille());
        prSt.setDouble(6, donnee.getSalaire());
        prSt.setString(7, donnee.getProfession());
        prSt.setString(8, donnee.getSituationFamiliale());
        prSt.setString(9, donnee.getIdLocataire());
    }

}
