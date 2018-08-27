package itacademy.domain.dao.impl;

import itacademy.domain.entity.Branch;
import itacademy.domain.entity.Subdivision;
import itacademy.domain.entity.SystemUser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class SystemUserDaoImplTest {

    @Test
    public void save() {
        SystemUserDaoImpl dao = SystemUserDaoImpl.getInstance();
        SystemUser systemUser = new SystemUser();
        systemUser.setName("Пользователь тест");
        systemUser.setFamaly("Фамилия тест");
        systemUser.setEmail("email test");
        systemUser.setPassword("pass test");
        systemUser.setBranchId(new Branch("филиал тест"));
        systemUser.setSubdivisionId(new Subdivision("админ тест"));
        Long id = dao.save(systemUser);
        Assert.assertNotNull(id);
        Optional<SystemUser> optionalSystemUser = dao.findById(id);
        String nameSystemUser = "";
        if (optionalSystemUser.isPresent()) {
            nameSystemUser = optionalSystemUser.get().getName();
        }
        Assert.assertEquals(systemUser.getName(), nameSystemUser);
        dao.delete(id);
    }

    @Test
    public void findAll() {
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        userList.forEach(System.out::println);
    }

}