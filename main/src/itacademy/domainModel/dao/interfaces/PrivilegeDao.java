package itacademy.domainModel.dao.interfaces;

import itacademy.domainModel.entity.Privilege;

import java.util.List;

public interface PrivilegeDao {

    Privilege findById(Long id);

    Long save(Privilege privilege);

    List<Privilege> findAll();

}
