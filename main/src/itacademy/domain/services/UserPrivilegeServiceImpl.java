package itacademy.domain.services;

import itacademy.domain.dao.impl.PrivilegeDaoImpl;
import itacademy.domain.dao.impl.UserPrivilegeDaoImpl;
import itacademy.domain.entity.Privilege;
import itacademy.domain.entity.UserPrivilege;
import itacademy.domain.services.interfaces.UserPrivilegeService;

import java.util.List;

public class UserPrivilegeServiceImpl implements UserPrivilegeService {
    private static final Object LOCK = new Object();
    private static UserPrivilegeServiceImpl INSTANCE = null;

    public static UserPrivilegeServiceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserPrivilegeServiceImpl();
                }
            }
        }
        return INSTANCE;
    }

    private UserPrivilegeServiceImpl() {
    }

    @Override
    public List<UserPrivilege> findAllUsersPrivilegesByUserId(Long userId) {
        return UserPrivilegeDaoImpl.getInstance().findAllByUserId(userId);
    }
}
