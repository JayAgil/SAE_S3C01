package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

public class RequeteUpdateChargesGenerales extends Requete<ChargesGenerales> {
    @Override
    public String requete() {
        return " Update MSF5131A.SAE_CHARGES_GENERALE set POURCENTAGE = ?, QUOTITE =  ? Where ID_CHARGES_GENERALE = ? ";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, ChargesGenerales donnee)
        throws SQLException {
        prSt.setFloat(1, donnee.getPourcentage());
        prSt.setDouble(2, donnee.getQuotite());
        prSt.setString(3, donnee.getIdChargesGenerales());
    }

}
