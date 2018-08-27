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
        System.out.println("нужна проверка теста");
        SystemUserDaoImpl user = SystemUserDaoImpl.getInstance();
        SystemUser systemUser = new SystemUser();
        systemUser.setName("Пользователь тест");
        systemUser.setFamaly("Фамилия тест");
        systemUser.setEmail("email test");
        systemUser.setPassword("pass test");
        systemUser.setBranchId(new Branch("филиал тест"));
        systemUser.setSubdivisionId(new Subdivision("админ тест"));
        Long id = user.save(systemUser);
        Assert.assertNotNull(id);
        Optional<SystemUser> optionalSystemUser = user.findById(id);
        String nameSystemUser = "";
        if (optionalSystemUser.isPresent()) {
            nameSystemUser = optionalSystemUser.get().getName();
        }
        Assert.assertEquals(systemUser.getName(), nameSystemUser);
        user.delete(id);
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void findByIdPrcTest() {
        SystemUser user = null;
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        SystemUser systemUser = userList.get(0);
        Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findByIdPrc(systemUser.getId());
        if (optionalSystemUser.isPresent()) {
            user = optionalSystemUser.get();
        }
        Assert.assertEquals(systemUser.getName(), user.getName());
    }
}