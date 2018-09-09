package itacademy.domain.services;

import itacademy.dto.models.TaskDto;
import org.junit.Assert;
import org.junit.Test;

public class TaskServiceImplTest {

    @Test
    public void save() {
        TaskServiceImpl taskService = TaskServiceImpl.getInstance();
        TaskDto taskDto = new TaskDto();
        taskDto.setName("name save test");
        taskDto.setText("text save test");
        taskDto.setListenerId(1L);
        taskDto.setSystemUserId(23L);
        taskDto.setStatusId(2L);
        Long id = taskService.saveTask(taskDto);
        Assert.assertNotNull(id);
    }

    @Test
    public void saveTask() {

    }
}