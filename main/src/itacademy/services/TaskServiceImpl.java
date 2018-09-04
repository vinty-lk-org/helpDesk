package itacademy.services;

import itacademy.connection.ConnectionManager;
import itacademy.dto.TaskDto;

import java.sql.*;

public class TaskServiceImpl implements TaskService {
    private static final String SQL_SAVE = "INSERT INTO tasks (name,  text)" + "VALUES (?, ?);";

    @Override
    public Long saveTask(TaskDto task) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getText());
                preparedStatement.executeUpdate();
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
}
