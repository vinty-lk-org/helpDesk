package itacademy.domainModel.dao;

import itacademy.domainModel.dao.interfaces.PrivilegeDao;
import itacademy.domainModel.entity.Privilege;

import java.util.List;

public class PrivilegeDaoImpl implements PrivilegeDao {

    @Override
    public Privilege findById(Long id) {
        return null;
    }

    @Override
    public Long save(Privilege privilege) {
        return 0L;
    }

    @Override
    public List<Privilege> findAll() {
        return null;
    }
}
