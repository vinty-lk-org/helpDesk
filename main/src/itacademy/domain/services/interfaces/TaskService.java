package itacademy.domain.services.interfaces;

import itacademy.domain.entity.Task;
import itacademy.dto.models.TaskDto;
import itacademy.dto.views.TaskViewUserDto;

import java.util.List;

public interface TaskService {

    List<TaskViewUserDto> findAllSelf(Long id);

    Long saveTask(TaskDto taskDto);

}
