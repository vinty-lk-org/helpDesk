package itacademy.domain.dao.impl;

import itacademy.domain.entity.Privilege;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PrivilegeDaoImplTest {

    @Test
    public void findAllTest() {
        PrivilegeDaoImpl dao = PrivilegeDaoImpl.getInstance();
        Long id1 = dao.save(new Privilege("testData1"));
        Long id2 = dao.save(new Privilege("testData2"));
        List<Privilege> privilegeList = dao.findAll();

        Assert.assertNotNull(privilegeList);
        Assert.assertTrue(privilegeList.size() >= 2);

        for (Privilege target : privilegeList) {
            if (target.getId().equals(id1)) {
                Assert.assertEquals(target.getName(), "testData1");
            }
            dao.delete(id1);
            dao.delete(id2);
        }
    }

    @Test
    public void save() {
        PrivilegeDaoImpl dao = PrivilegeDaoImpl.getInstance();
        Privilege privilege = new Privilege();
        privilege.setName("Работа №1");
        Long id = dao.save(privilege);
        Assert.assertNotNull(id);
        Optional<Privilege> optionalPrivilege = dao.findById(id);
        String nameSubdivision = "";
        if (optionalPrivilege.isPresent()) {
            nameSubdivision = optionalPrivilege.get().getName();
        }
        Assert.assertEquals(privilege.getName(), nameSubdivision);
        dao.delete(id);
    }
}