package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.Paiement;

public class RequeteUpdatePaiement extends Requete<Paiement>{
    @Override
    public String requete() {
        return " Update MSF5131A.SAE_PAIEMENT SET Montant =  ?, Date_Paiement = ?, Designation_Paiement = ?, fk_Numero_de_contrat = ? Where Id_Paiement = ? ";

    }

    @Override
    public void parametres(PreparedStatement prSt, Paiement donnee)
        throws SQLException {
        prSt.setDouble(1, donnee.getMontant());
        prSt.setDate(2, donnee.getDatepaiement());
        prSt.setString(3, donnee.getDesignation());
        prSt.setString(4, donnee.getContratLocation().getNumeroDeContrat());
        prSt.setString(5, donnee.getId_paiement());
    }
}
