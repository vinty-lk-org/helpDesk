package itacademy.domain.services;

import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.UserPrivilege;
import itacademy.dto.models.SystemUserDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserPrivilegeServiceImplTest {

    @Test
    public void findAllUsersPrivilegesByUserId() {
        List<SystemUser> systemUserList = SystemUserDaoImpl.getInstance().findAll();
        SystemUser systemUser = systemUserList.get(0);
        List<UserPrivilege> userPrivilegeList = UserPrivilegeServiceImpl.getInstance().findAllUsersPrivilegesByUserId(systemUser.getId());
        Assert.assertNotNull(userPrivilegeList.get(0));

    }
}