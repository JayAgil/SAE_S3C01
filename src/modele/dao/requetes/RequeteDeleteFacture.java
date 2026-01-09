package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;
import modele.Facture;

public class RequeteDeleteFacture extends Requete<Facture> {
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Facture where Numero_Facture = ?";
	}
	
	@Override
	public void parametres(PreparedStatement ps, Facture f) throws SQLException {
		ps.setString(1, f.getNumeroFacture());

	}
}
