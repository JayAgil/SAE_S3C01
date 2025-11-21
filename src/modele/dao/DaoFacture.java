package modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import modele.dao.requetes.*;
import modele.BienLouable;
import modele.Entreprise;
import modele.Facture;

public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	@Override
	public void create(Facture t) {
		DaoTest.insertFacture(t);

	}

	@Override
	public void update(Facture t) {
		DaoTest.updateFacture(t);

	}

	@Override
	public void delete(Facture t) {
		DaoTest.deleteFacture(t);

	}

	@Override
	public Facture findById(String... id) throws SQLException {
		return findById(new RequeteSelectFactureById(), id);
	}

	@Override
	public List<Facture> findAll() throws SQLException {
		return find(new RequeteSelectFacture());
	}

	@Override
	protected Facture creerInstance(ResultSet rs) throws SQLException {
		
		DaoBienLouable dBL = new DaoBienLouable();
		DaoEntreprise dE = new DaoEntreprise();
		
		String numeroFacture = rs.getString(1);
		double montant = rs.getDouble(2);
		Date dateDeFacture = rs.getDate(3);
		String compteBancaire = rs.getString(4);
		double montantDevis = rs.getDouble(5);
		Date datePaiement = rs.getDate(6);
		String designationDeTravaux = rs.getString(7);
		BienLouable bienLouable = dBL.findById(rs.getString(8));
		Entreprise entreprise = dE.findById(rs.getString(9));
		
		return new Facture(numeroFacture, montant, dateDeFacture, compteBancaire, montantDevis, datePaiement, designationDeTravaux, bienLouable, entreprise);

	}

}
