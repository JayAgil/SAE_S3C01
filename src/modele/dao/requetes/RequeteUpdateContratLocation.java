package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele.ContratLocation;

public class RequeteUpdateContratLocation extends Requete<ContratLocation> {

    @Override
    public String requete() {
        return "UPDATE MSF5131A.SAE_ContratLocation SET "
             + "Date_debut = ?, "
             + "Date_Fin = ?, "
             + "Montant_de_caution = ?, "
             + "Provision_Charge = ?, "
             + "Solde = ?, "
             + "Montant_Mensuel = ?, "
             + "Date_versement = ?, "
             + "Index_Compteur_Eau = ?, "
             + "Index_Compteur_Electricite = ?, "
             + "Index_Compteur_Gaz = ? "
             + "WHERE Numero_de_contrat = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, ContratLocation donnee)
            throws SQLException {

        prSt.setDate(1, donnee.getDateDebut());
        prSt.setDate(2, donnee.getDateFin());
        prSt.setDouble(3, donnee.getMontantDeCaution());
        prSt.setDouble(4, donnee.getProvisionCharge());
        prSt.setDouble(5, donnee.getSolde());
        prSt.setDouble(6, donnee.getMontantMensuel());
        prSt.setDate(7, donnee.getDateVersement());
        prSt.setDouble(8, donnee.getIndexCompteurEau());
        prSt.setDouble(9, donnee.getIndexCompteurElectricite());
        prSt.setDouble(10, donnee.getIndexCompteurGaz());
        prSt.setString(11, donnee.getNumeroDeContrat());
    }
}
