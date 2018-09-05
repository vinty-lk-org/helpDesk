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
    public void findAll() {
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        SystemUserDaoImpl userDao = SystemUserDaoImpl.getInstance();
        BranchDaoImpl branchDao = BranchDaoImpl.getInstance();
        SubdivisionDaoImpl subdivisionDao = SubdivisionDaoImpl.getInstance();
        long countRecordOnStart = userList.size();
        SystemUser systemUser = new SystemUser();
        systemUser.setEmail("myEmail");
        systemUser.setPassword("myPass");
        systemUser.setBranch(branchDao.findAll().get(0));
        systemUser.setSubdivision(subdivisionDao.findAll().get(0));
        System.out.println(systemUser);
        Long id = userDao.save(systemUser);
        userList = userDao.findAll();
        Assert.assertEquals(1, (userList.size() - countRecordOnStart));
        userDao.delete(id);
    }

    @Test
    public void findById() {
        SystemUser user = null;
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        SystemUser systemUser = userList.get(0);
        Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findById(systemUser.getId());
        if (optionalSystemUser.isPresent()) {
            user = optionalSystemUser.get();
        }
        Assert.assertEquals(systemUser.getName(), user.getName());
    }

    @Test
    public void save() {
        SystemUserDaoImpl dao = SystemUserDaoImpl.getInstance();
        SystemUser systemUser = new SystemUser();
        systemUser.setName("Пользователь тест");
        systemUser.setFamily("Фамилия тест");
        systemUser.setEmail("email test");
        systemUser.setPassword("pass test");
        systemUser.setBranch(new Branch(3L, "Минск", "Минск-сити"));
        systemUser.setSubdivision(new Subdivision(1L, "админ тест"));
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
    public void findByEmail() {
        SystemUser systemUser = null;
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        String email = userList.get(0).getEmail();
        Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findByEmail(email);
        if (optionalSystemUser.isPresent()) {
            systemUser = optionalSystemUser.get();
        }
        Assert.assertEquals(email, systemUser.getEmail());
    }
}