package itacademy.domain.services;

import itacademy.domain.entity.Privilege;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PrivilegeServiceImplTest {

    @Test
    public void getAllPrivilege() {
        List<Privilege> allPrivilege = PrivilegeServiceImpl.getInstance().getAllPrivilege();
        Assert.assertNotNull(allPrivilege);
        Assert.assertTrue(allPrivilege.size() >= 4);
    }
}