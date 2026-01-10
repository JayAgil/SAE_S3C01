package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import modele.Batiment;
import modele.BienLouable;
import modele.dao.requetes.*;

public class DaoBienLouable extends DaoModele<BienLouable> implements Dao<BienLouable> {

    public DaoBienLouable() throws SQLException {
        super();
    }

    @Override
    public int create(BienLouable t) throws SQLException {
        return miseAJour(new RequeteInsertBienLouable(), t);
    }

    @Override
    public int update(BienLouable t) throws SQLException {
        return miseAJour(new RequeteUpdateBienLouable(), t);
    }

    @Override
    public int delete(BienLouable t) throws SQLException {
        return miseAJour(new RequeteDeleteBienLouable(), t);
    }

    @Override
    public BienLouable findById(String... id) throws SQLException {
        return this.findById(new RequeteSelectBienLouableById(), id);
    }

    public BienLouable findByIdContrat(String... id) throws SQLException {
        return this.findById(new RequeteSelectBienFromContrat(), id);
    }

    @Override
    public List<BienLouable> findAll() throws SQLException {
        return this.find(new RequeteSelectBienLouable());
    }

    public List<BienLouable> findByBatiment(String... id) throws SQLException {
        return this.find(new RequeteSelectBienLouableByBat(), id);
    }

    public List<BienLouable> findByIdBat(String... id) throws SQLException {
    	List<BienLouable> result =  this.find(new RequeteSelectBienLouableByBat(), id);
    	if (result == null) {
    	    return Collections.emptyList();
    	}
    	return result;
    }
    
    public BienLouable findByIdLoc(String...id) throws SQLException {
        return this.findById(new RequeteSelectBienLouableByIdLoc(), id);
    }
    
    public BienLouable findByIdCharge(String...id) throws SQLException {
        return this.findById(new RequeteSelectBienByIdCharge(), id);
    }
    
    public BienLouable findByIdCompteur(String...id) throws SQLException {
        return this.findById(new RequeteSelectBienFromCompteur(), id);
    }

    @Override
    protected BienLouable creerInstance(ResultSet curseur) throws SQLException {
        String idBienLouable = curseur.getString(1);
        String numFiscale = curseur.getString(2);
        String adresse = curseur.getString(3);
        double surface = curseur.getDouble(4);
        int nbPieces = curseur.getInt(5);
        String typeBienLouable = curseur.getString(6);

        String idBien2 = curseur.getString(7); 
        String idBatiment = curseur.getString(8);

        Batiment batiment = null;
        if (idBatiment != null && !idBatiment.isEmpty()) {
            DaoBatiment daoBat = new DaoBatiment();
            batiment = daoBat.findById(idBatiment);
        }

        BienLouable bien2 = null;
        if (idBien2 != null && !idBien2.isEmpty()) {
            DaoBienLouable daoBl = new DaoBienLouable();
            bien2 = daoBl.findById(idBien2);
        }

        return new BienLouable(
            idBienLouable,
            numFiscale,
            adresse,
            surface,
            nbPieces,
            typeBienLouable,
            batiment,
            bien2
        );
    }
}
