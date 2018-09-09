package itacademy.domain.services;

import itacademy.connection.ConnectionManager;
import itacademy.domain.entity.Task;
import itacademy.dto.models.TaskDto;
import itacademy.domain.services.interfaces.TaskService;

import java.sql.*;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private static final String SQL_SAVE = "INSERT INTO tasks (name,  text)" + "VALUES (?, ?);";
    private static final Object LOCK = new Object();
    private static TaskServiceImpl INSTANCE = null;

    private TaskServiceImpl() {
    }

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
    public Long save(TaskDto task) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getText());
                preparedStatement.executeUpdate();
                connection.commit();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getLong("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Task> findAllSelf(Long id) {
        return null;
    }


}
