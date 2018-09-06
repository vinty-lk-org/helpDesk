package itacademy.domain.dao.impl;

import itacademy.domain.entity.Listener;
import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class TaskDaoImplTest {

    @Test
    public void findAllTest() {
        List<Task> taskList = TaskDaoImpl.getInstance().findAll();
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    @Test
    public void findAll() {
        List<Task> taskList = TaskDaoImpl.getInstance().findAll();
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    @Test
    public void save() {
        TaskDaoImpl dao = TaskDaoImpl.getInstance();
        Task task = Task.builder()
                .name("Заявка №2")
                .listener(new Listener(1L))
                .text("текст заявки")
                .systemUserId(new SystemUser(22L))
                .executorId(new SystemUser(22L))
                .operatorId(new SystemUser(23L))
                .status_id(1L)
                .build();
        Long id = dao.save(task);
        Assert.assertNotNull(id);
        Optional<Task> optionalTask = dao.findById(id);
        String taskuser = "";
        if (optionalTask.isPresent()) {
            taskuser = optionalTask.get().getName();
        }
        Assert.assertEquals(task.getName(), taskuser);
        dao.delete(id);
    }

    @Test
    public void findByIdPrcTest() {
        Task task = null;
        List<Task> taskList = TaskDaoImpl.getInstance().findAll();
        Task taskUser = taskList.get(0);
        Optional<Task> optionalTask = TaskDaoImpl.getInstance().findById(taskUser.getId());
        if (optionalTask.isPresent()) {
            task = optionalTask.get();
        }
        Assert.assertEquals(taskUser.getName(), task.getName());
    }


}


//    @Test
//    public void saving() {
//        TaskDaoImpl dao = TaskDaoImpl.getInstance();
//        Task task = Task.builder()
//                .name("Заявка №1")
//                .listener(new Listener(1L))
//                .text("текст заявки")
//                .systemUserId(new SystemUser(22L))
//                .executorId(new SystemUser(22L))
//                .operatorId(new SystemUser(23L))
//                .build();
//        dao.save(task);
//        assertNotNull(task.getId());
//    }