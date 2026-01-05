package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.IRL;
import modele.dao.requetes.*;

public class DaoIRL extends DaoModele<IRL> implements Dao<IRL> {

    public DaoIRL() throws SQLException {
        super();
    }

    @Override
    public int create(IRL t) throws SQLException {
        return this.miseAJour(new RequeteInsertIRL(), t);
    }

    @Override
    public int delete(IRL t) throws SQLException {
        return 0;
    }

    @Override
    public IRL findById(String... id) throws SQLException {
        if (id.length == 1) {
            return findById(new RequeteSelectIRL(), id[0], "1");
        } else if (id.length == 2) {
            return findById(new RequeteSelectIRL(), id[0], id[1]);
        }
        return null;
    }

    @Override
    public List<IRL> findAll() throws SQLException {
        return find(new RequeteSelectIRL());
    }

    @Override
    protected IRL creerInstance(ResultSet rs) throws SQLException {
        int annee = rs.getInt("Annee");
        int trimestre = rs.getInt("Trimestre");
        double valeur = rs.getDouble("IRL");
        return new IRL(annee, trimestre, valeur);
    }

    @Override
    public int update(IRL t) throws SQLException {
        return 0;
    }
}
