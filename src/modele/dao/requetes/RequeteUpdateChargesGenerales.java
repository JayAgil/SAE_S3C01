package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ChargesGenerales;

public class RequeteUpdateChargesGenerales extends Requete<ChargesGenerales> {
    @Override
    public String requete() {
        return "UPDATE MSF5131A.SAE_Charges_Generale " +
                "SET Type_Charge = ?, " +
                "Montant_Total = ?, " +
                "Pourcentage = ?, " +
                "Quotite = ?, " +
                "Mois = ?, " +
                "WHERE Id_Charges_Generale = ?";
    }

  
    @Override
    public void parametres(PreparedStatement prSt, ChargesGenerales donnee)
        throws SQLException {
        prSt.setString(1, donnee.getTypeCharge());
        prSt.setDouble(2, donnee.getMontant());
        prSt.setFloat(3, donnee.getPourcentage());
        prSt.setDouble(4, donnee.getQuotite());
        prSt.setString(5, donnee.getMois());
        prSt.setString(6, donnee.getIdChargesGenerales());
    }

}
