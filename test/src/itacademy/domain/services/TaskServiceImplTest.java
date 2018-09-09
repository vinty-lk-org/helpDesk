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
        Long id = taskService.save(taskDto);
        Assert.assertNotNull(id);
//        taskService.delete(id);

    }
}