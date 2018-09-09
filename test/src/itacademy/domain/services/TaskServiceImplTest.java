package itacademy.domain.services;

import itacademy.dto.models.TaskDto;
import itacademy.dto.views.TaskViewUserDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void findAllSelfTest() {
        List<TaskViewUserDto> viewUserDto = TaskServiceImpl.getInstance().findAllSelf(23L);
        Assert.assertNotNull(viewUserDto);
        for (TaskViewUserDto taskViewUserDto : viewUserDto) {
            System.out.println(taskViewUserDto);
        }
    }
}
