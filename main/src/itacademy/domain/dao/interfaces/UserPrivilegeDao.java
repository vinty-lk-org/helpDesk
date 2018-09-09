package itacademy.domain.dao.interfaces;

import itacademy.domain.dao.common.BaseDao;
import itacademy.domain.entity.Privilege;
import itacademy.domain.entity.UserPrivilege;

import java.util.List;

public interface UserPrivilegeDao {

    List<UserPrivilege> findAllByUserId(Long id);

}