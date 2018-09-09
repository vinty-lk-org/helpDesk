package itacademy.domain.services.interfaces;

import itacademy.dto.views.TaskViewUserDto;

import java.util.List;

public interface TaskService {

    List<TaskViewUserDto> findAllSelf(Long id);
}
