package itacademy.domain.dao.impl;

import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.UserPrivilege;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserPrivilegeDaoImplTest {

    @Test
    public void findAllByUserId() {
        List<SystemUser> systemUserList = SystemUserDaoImpl.getInstance().findAll();
        SystemUser systemUser = systemUserList.get(0);
        List<UserPrivilege> userPrivilegeList = UserPrivilegeDaoImpl.getInstance().findAllByUserId(systemUser.getId());
        Assert.assertNotNull(userPrivilegeList);
    }
}