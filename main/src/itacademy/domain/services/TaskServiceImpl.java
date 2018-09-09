package itacademy.domain.services;

import itacademy.domain.dao.impl.TaskDaoImpl;
import itacademy.domain.entity.Task;
import itacademy.domain.services.interfaces.TaskService;
import itacademy.dto.views.TaskViewUserDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private static final Object LOCK = new Object();
    private static TaskServiceImpl INSTANCE = null;

    public static TaskServiceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskServiceImpl();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public List<TaskViewUserDto> findAllSelf(Long id) {
        return mapperListTaskViewUserDto(TaskDaoImpl.getInstance().findSelfTasks(id));
    }

    private List<TaskViewUserDto> mapperListTaskViewUserDto(List<Task> taskList) {
        return taskList.stream()
                .map(task -> new TaskViewUserDto(
                        task.getId(),
                        task.getName(),
                        task.getSystemUserId().getId(),
                        task.getListener().getName(),
                        task.getStatus().getName()
                ))
                .collect(Collectors.toList());
    }


}
