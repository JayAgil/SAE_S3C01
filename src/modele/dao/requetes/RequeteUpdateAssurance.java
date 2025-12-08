package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteUpdateAssurance extends Requete<Assurance> {
    @Override
    public String requete() {
        return " Update MSF5131A.SAE_Assurance set PRIME =  ?, MONTANT = ? Where NUMERO_D_ASSURANCE = ?";

    }

    @Override
    public void parametres(PreparedStatement prSt, String... id)
        throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Assurance donnee)
        throws SQLException {
        prSt.setDouble(1, donnee.getPrime());
        prSt.setDouble(2, donnee.getMontant());
        prSt.setString(3, donnee.getNumeroAssurance());
    }

}
