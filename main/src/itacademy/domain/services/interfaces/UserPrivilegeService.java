package itacademy.domain.services.interfaces;

import itacademy.domain.entity.UserPrivilege;

import java.util.List;

public interface UserPrivilegeService {

    List<UserPrivilege> findAllUsersPrivilegesByUserId(Long userId);

}
