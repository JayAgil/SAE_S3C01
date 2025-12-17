package modele.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modele.dao.requetes.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.BienLouable;
import modele.ContratLocation;

public class DaoContratLocation extends DaoModele<ContratLocation> implements Dao<ContratLocation> {

	public DaoContratLocation() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(ContratLocation t) throws SQLException {
		return miseAJour(new RequeteInsertContratLocation(), t);	
	}
	
	@Override
	public int update(ContratLocation t) throws SQLException {
		return miseAJour(new RequeteUpdateContratLocation(), t);
	}

	@Override
	public int delete(ContratLocation t) throws SQLException {
		return miseAJour(new RequeteDeleteContratLocation(), t);
		
	}

	@Override
	public ContratLocation findById(String... id) throws SQLException {
		return this.findById(new RequeteSelectContratLocationById(), id);

	}

	@Override
	public List<ContratLocation> findAll() throws SQLException {
		return this.find(new RequeteSelectContratLocation());
	}
	
	public ContratLocation findCLByBien(String... id) throws SQLException {
		return this.findById(new RequeteSelectContratLocationByBien(), id);
	}

	@Override
	protected ContratLocation creerInstance(ResultSet curseur) throws SQLException {
		String numeroDeContrat = curseur.getString(1);
		Date dateDebut = curseur.getDate(2);
		Date dateFin = curseur.getDate(3);
		double montantCaution = curseur.getDouble(4);
		double provisionCharge = curseur.getDouble(5);
		double solde = curseur.getDouble(6);
		double montantMensuel = curseur.getDouble(7);
		Date dateVersement = curseur.getDate(8);
		double indexCompteurEau = curseur.getDouble(9);
		double indexCompteurElectricite = curseur.getDouble(10);
		double indexCompteurGaz = curseur.getDouble(11);
		String id = curseur.getString(12);
		DaoBienLouable daoBL = new DaoBienLouable();
		BienLouable bl = daoBL.findById(id);
		return new ContratLocation(numeroDeContrat,dateDebut,dateFin,montantCaution,provisionCharge,solde,montantMensuel,dateVersement,indexCompteurEau,indexCompteurElectricite,indexCompteurGaz,bl);
	}
	
	public List<ContratLocation> findByBienLouable(String... id) throws SQLException {
	        return this.find(new RequeteSelectContratLocation(), id);
	}

}
