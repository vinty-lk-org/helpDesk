package itacademy.domain.services;

import itacademy.domain.dao.impl.TaskDaoImpl;
import itacademy.domain.entity.Listener;
import itacademy.domain.entity.Status;
import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.Task;
import itacademy.domain.services.interfaces.TaskService;
import itacademy.dto.models.TaskDto;
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

    @Override
    public Long saveTask(TaskDto taskDto) {
        return TaskDaoImpl.getInstance().save(mapperTaskDtoToTask(taskDto));
    }

    private Task mapperTaskDtoToTask(TaskDto taskDto) {
        return new Task(
                taskDto.getName(),
                new Listener(taskDto.getListenerId()),
                taskDto.getText(),
                new SystemUser(taskDto.getSystemUserId()),
                new Status(taskDto.getStatusId())
        );
    }

    private String name;
    private Long listenerId;
    private String text;
    private Long systemUserId;
    private Long statusId;

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
