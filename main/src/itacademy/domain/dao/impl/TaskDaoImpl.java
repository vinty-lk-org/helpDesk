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
                        resultSet.getLong("s_id")),
                new SystemUser(
                        resultSet.getLong("s_id")),
                new SystemUser(
                        resultSet.getLong("s_id")));
    }

    @Override
    public Long save(Task entity) {
        return null;
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

    @Override
    public List<Task> findAll() {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = "select\n" +
                    "  t.id,\n" +
                    "  t.name,\n" +
                    "  t.text,\n" +
                    "  l.id l_id,\n" +
                    "  l.name l_name,\n" +
                    "  s.id s_id,\n" +
                    "  s.name s_name,\n" +
                    "  s.family s_family,\n" +
                    "  s.e_mail s_email,\n" +
                    "  s.privilege_id,\n" +
                    "  s.branch_id,\n" +
                    "  s.subdivision_id\n" +
                    "from tasks t,\n" +
                    "  listeners l,\n" +
                    "  system_users s\n" +
                    "where t.listener_id = l.id\n" +
                    "      and t.system_user_id = s.id;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        taskList.add(createTaskDaoFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    public List<Task> findAllPrc() {
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

}
