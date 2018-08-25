package itacademy.domain.dao.interfaces;

import itacademy.domain.entity.*;

import java.util.*;

public interface PrivilegeDao {


    Optional<Privilege> findById(Long id);

    Long save(Privilege privilege);


    List<Privilege> findAll();

    void delete(Long id);
}
