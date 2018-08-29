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
        SystemUserDaoImpl user = SystemUserDaoImpl.getInstance();
        SystemUser systemUser = new SystemUser();
        systemUser.setName("Пользователь тест");
        systemUser.setFamaly("Фамилия тест");
        systemUser.setEmail("email test");
        systemUser.setPassword("pass test");
        systemUser.setBranch(new Branch(3L, "Минск", "Минск-сити"));
        systemUser.setSubdivision(new Subdivision(1L, "админ тест"));
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
    //TODO Тест - хардкод. Негодный.
    @Test
    public void findByEmail() {
        SystemUser user = null;
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        SystemUser systemUser = userList.get(0);
        Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findByEmail("lkghost7@gmail.com");
        if (optionalSystemUser.isPresent()) {
            user = optionalSystemUser.get();
        }
        // TODO ЭТО ЧТО ЗА ПИЗДЕЦ???????
        // TODO Если Идея тебе что-то подсказывает - этоне значит, что надо бездумно это вставлять!
        // TODO - что ты проверяешь? Не пусто ли в user??? АХУЕТЬ!!! Ты только что это проверил!!!
        // TODO - вот ЭТИМ кодом!
        // TODO if (optionalSystemUser.isPresent()) {
        // TODO           user = optionalSystemUser.get();
        // TODO       }
        assert user != null;
        Assert.assertEquals(systemUser.getEmail(), user.getEmail());
    }
    // TODO А это что за адовое название??? этот метод проверяет вторую почту? У тебя их ДВЕ?!!!
    //TODO Тест - хардкод. Негодный.
    @Test
    public void findByEmail2() {
        SystemUser user = null;
        List<SystemUser> userList = SystemUserDaoImpl.getInstance().findAll();
        SystemUser systemUser = userList.get(0);
//        System.out.println(systemUser);
        Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findByemail2("lkghost7@gmail.com");
//        String emailTest = systemUser.getEmail();
//        System.out.println(optionalSystemUser);
//        user = optionalSystemUser.get();
//        System.out.println(user);
//        System.out.println(systemUser.getEmail());
//        System.out.println(user.getEmail());
        if (optionalSystemUser.isPresent()) {
            user = optionalSystemUser.get();
        }
        Assert.assertEquals(systemUser.getEmail(), user.getEmail());
    }

    @Test
    public void findByEmailPrc() {
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

}