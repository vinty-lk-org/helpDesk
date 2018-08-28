package itacademy.domain.dao.impl;

import itacademy.domain.dao.interfaces.TaskDao;
import itacademy.domain.entity.Task;

import java.util.List;
import java.util.Optional;

public class TaskDaoImpl implements TaskDao {
    private static final Object LOCK = new Object();
    private static TaskDaoImpl INSTANCE = null;

    public static TaskDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskDaoImpl();
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public Long save(Task entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }
}
