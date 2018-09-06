package itacademy.services.interfaces;

import itacademy.dto.models.TaskDto;

public interface TaskService {
    Long saveTask(TaskDto TaskDto);
}
