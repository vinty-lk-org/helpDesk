package itacademy.domain.services;

import itacademy.dto.views.TaskViewUserDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TaskServiceImplTest {

    @Test
    public void findAllSelfTest() {
        List<TaskViewUserDto> viewUserDto = TaskServiceImpl.getInstance().findAllSelf(23L);
        Assert.assertNotNull(viewUserDto);
        for (TaskViewUserDto taskViewUserDto : viewUserDto) {
            System.out.println(taskViewUserDto);
        }
    }
}