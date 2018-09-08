package itacademy.domain.services;

import itacademy.domain.dao.impl.PrivilegeDaoImpl;
import itacademy.domain.entity.Privilege;
import itacademy.domain.services.interfaces.PrivilegeService;

import java.util.List;

public class PrivilegeServiceImpl implements PrivilegeService {
    private static final Object LOCK = new Object();
    private static PrivilegeServiceImpl INSTANCE = null;

    public static PrivilegeServiceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PrivilegeServiceImpl();
                }
            }
        }
        return INSTANCE;
    }

    private PrivilegeServiceImpl() {
    }

    @Override
    public List<Privilege> getAllPrivilege() {
        return PrivilegeDaoImpl.getInstance().findAll();
    }
}
