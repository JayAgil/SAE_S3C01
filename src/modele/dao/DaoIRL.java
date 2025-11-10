package modele.dao;

import java.util.List;

import modele.IRL;

public class DaoIRL implements Dao<IRL> {

    @Override
    public void create(IRL t) {
        DaoTest.insertIRL(t);

    }

    @Override
    public void update(IRL t) {
        DaoTest.updateIRL(t);

    }

    @Override
    public void delete(IRL t) {
        DaoTest.deleteIRL(t);

    }

    @Override
    public IRL findById(String... id) {
        if (DaoTest.selectIRL(id).size() == 0) {
            return null;
        }
        return DaoTest.selectIRL(id).get(0);
    }

    @Override
    public List<IRL> findAll() {
        return DaoTest.selectIRL();
    }

}
