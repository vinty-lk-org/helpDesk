package itacademy.domain.services.interfaces;

import itacademy.domain.entity.Task;
import itacademy.dto.models.TaskDto;

import java.util.List;

public interface TaskService {

    Long save(TaskDto TaskDto);

    List<Task> findAllSelf(Long id);

}
