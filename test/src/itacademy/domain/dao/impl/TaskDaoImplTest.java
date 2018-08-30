package itacademy.domain.dao.impl;

import itacademy.domain.entity.Task;
import org.junit.Test;

import java.util.List;

public class TaskDaoImplTest {


    //    @Test
//    public void findAll() {
//        List<Task> taskList = TaskDaoImpl.getInstance().findAll();
//        TaskDaoImpl taskDao = TaskDaoImpl.getInstance();
//        BranchDaoImpl branchDao = BranchDaoImpl.getInstance();
//        SubdivisionDaoImpl subdivisionDao = SubdivisionDaoImpl.getInstance();
//        long countRecordOnStart = userList.size();
//        SystemUser systemUser = new SystemUser();
//        systemUser.setEmail("myEmail");
//        systemUser.setPassword("myPass");
//        systemUser.setBranch(branchDao.findAll().get(0));
//        systemUser.setSubdivision(subdivisionDao.findAll().get(0));
//        Long id = userDao.save(systemUser);
//        userList = userDao.findAll();
//        Assert.assertEquals(1, (userList.size() - countRecordOnStart));
//        userDao.delete(id);
//    }
    @Test
    public void findAllTest() {
        List<Task> taskList = TaskDaoImpl.getInstance().findAll();
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

        @Test
        public void findAllPrc() {
            List<Task> taskList = TaskDaoImpl.getInstance().findAllPrc();
            for (Task task : taskList) {
                System.out.println(task);
            }
        //TODO Вроде работает.

    }
}