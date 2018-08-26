package itacademy.domain.dao.impl;

import itacademy.domain.entity.SystemUser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SystemUserDaoImplTest {

    @Test
    public void save() {
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
    public void findById() {
    }
}