package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteInsertLocataire extends Requete<Locataire> {

    @Override
    public String requete() {
        return "INSERT INTO MSF5131A.SAE_LOCATAIRE (" +
                "Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, " +
                "Date_de_naissance, Lieu_de_naissance, Salaire, Profession, Situation_Familiale, " +
                "Image_Locataire, fk_Id_Garant) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public void parametres(PreparedStatement ps, Locataire l) throws SQLException {

        ps.setString(1, l.getIdLocataire());
        ps.setString(2, l.getNom());
        ps.setString(3, l.getPrenom());
        ps.setString(4, l.getAdresse());
        ps.setString(5, l.getTel());
        ps.setString(6, l.getEmail());
        ps.setString(7, l.getCodePostale());
        ps.setString(8, l.getVille());
        ps.setDate(9, l.getDateDeNaissance());
        ps.setString(10, l.getLieuDeNaissance());
        ps.setDouble(11, l.getSalaire());
        ps.setString(12, l.getProfession());
        ps.setString(13, l.getSituationFamiliale());
        ps.setString(14, l.getImage());

        if (l.getGarant() != null)
            ps.setString(15, l.getGarant().getIdGarant());
        else
            ps.setNull(15, java.sql.Types.VARCHAR);
    }
}
