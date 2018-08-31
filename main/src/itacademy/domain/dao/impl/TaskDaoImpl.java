package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.TaskDao;
import itacademy.domain.entity.Listener;
import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.Task;

import java.sql.*;
import java.util.ArrayList;
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

    private Task createTaskDaoFromResultSet(ResultSet resultSet) throws SQLException {
        return new Task(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("text"),
                new Listener(
                        resultSet.getLong("l_id"),
                        resultSet.getString("l_name")),
                new SystemUser(
                        resultSet.getLong("s_id")));
    }

    @Override
    public List<Task> findAll() {
        List<Task> taskList = new ArrayList<>();
        String sql = "{ ? = call tasks_find_all()}";
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(sql)) {
            connection.setAutoCommit(false);
            proc.registerOutParameter(1, Types.OTHER);
            proc.execute();
            ResultSet resultSet = (ResultSet) proc.getObject(1);
            while (resultSet.next()) {
                taskList.add(createTaskDaoFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @Override
    public Optional<Task> findById(Long id) {
        String sql = "{ ? = call tasks_findbyid(?)}";
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(sql)) {
            connection.setAutoCommit(false);
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2, Math.toIntExact(id));
            proc.execute();
            ResultSet resultSet = (ResultSet) proc.getObject(1);
            while (resultSet.next()) {
                return Optional.of(createTaskDaoFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(Task task) {
        Long id = 0L;
        String sql = "INSERT INTO tasks (name, listener_id, text, system_user_id, executor_id, operator_id)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, task.getName());
                preparedStatement.setLong(2, task.getListener().getId());
                preparedStatement.setString(3, task.getText());
                preparedStatement.setLong(4, task.getSystemUserId().getId());
                preparedStatement.setLong(5, task.getExecutorId().getId());
                preparedStatement.setLong(6, task.getOperatorId().getId());
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

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM tasks WHERE (id = ?)";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = (connection.prepareStatement(sql))) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}