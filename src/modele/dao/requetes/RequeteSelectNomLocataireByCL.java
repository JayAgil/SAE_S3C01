package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class RequeteSelectNomLocataireByCL extends Requete<Locataire> {
	@Override
    public String requete() {
        return "SELECT l.Nom FROM SAE_Locataire l, SAE_Contrat_Locataire cl WHERE l.Id_Locataire = cl.Id_Locataire AND cl.Numero_de_contrat = ? ";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... params) throws SQLException {
        prSt.setString(1, params[0]);
    }

}
