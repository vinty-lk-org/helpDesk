package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.TaskDao;
import itacademy.domain.entity.Listener;
import itacademy.domain.entity.Status;
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

    private Task createFindSelfFromResultSet(ResultSet resultSet) throws SQLException {
        return new Task(
                resultSet.getLong("t_id"),
                resultSet.getString("t_name"),
                new SystemUser(resultSet.getLong("t_system_user_id")),
                new Listener(resultSet.getString("l_name")),
                new Status(resultSet.getString("s_name")));
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
                        resultSet.getLong("s_id")),
                new Status(resultSet.getLong("st_status_id")));
    }


    private static final String SQL_FIND_ALL = "{ ? = call tasks_find_all()}";

    @Override
    public List<Task> findAll() {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(SQL_FIND_ALL)) {
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

    private static final String SQL_FIND_SELF_TASKS = "select t.id as t_id, t.name as t_name, t.system_user_id as t_system_user_id, l.name as l_name,\n" +
            "  s.name as s_name\n" +
            "from tasks t, listeners l, status s\n" +
            "where\n" +
            "  t.listener_id = l.id\n" +
            "  and t.status_id = s.id\n" +
            "  and t.system_user_id = ?;\n";

    @Override
    public List<Task> findSelfTasks(Long id) {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = (connection.prepareStatement(SQL_FIND_SELF_TASKS))) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    taskList.add(createFindSelfFromResultSet(resultSet));
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return taskList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    private static final String SQL_FIND_ID = "{ ? = call tasks_findbyid(?)}";

    @Override
    public Optional<Task> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(SQL_FIND_ID)) {
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

    private static final String SQL_SAVE =
            "INSERT INTO tasks (name, listener_id, text, system_user_id, status_id)" + "VALUES (?, ?, ?, ?, ?);";

    @Override
    public Long save(Task task) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, task.getName());
                preparedStatement.setLong(2, task.getListener().getId());
                preparedStatement.setString(3, task.getText());
                preparedStatement.setLong(4, task.getSystemUserId().getId());
                preparedStatement.setLong(5, task.getStatus().getId());
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

    private static final String SQL_DELETE = "DELETE FROM tasks WHERE (id = ?)";

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = (connection.prepareStatement(SQL_DELETE))) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}