package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteUpdateAssurance extends Requete<Assurance> {
	@Override
	public String requete() {
		return "UPDATE SAE_Assurance " + "SET Prime = ?, " + "Montant = ?, " + "Type_assurance = ?, "
				+ "Agence = ?, " + "Adresse_agence = ?, " + "Tel_agence = ?, " + "WHERE Numero_d_assurance = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, Assurance a) throws SQLException {
		prSt.setDouble(1, a.getPrime());
		prSt.setDouble(2, a.getMontant());
		prSt.setString(3, a.getTypeAssurance());
		prSt.setString(4, a.getAgence());
		prSt.setString(5, a.getAdresseAgence());
		prSt.setString(6, a.getTelAgence());
		prSt.setString(7, a.getNumeroAssurance());
	}
}
