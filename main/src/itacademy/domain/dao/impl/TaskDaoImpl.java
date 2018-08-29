package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.TaskDao;
import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.TargetOfJob;
import itacademy.domain.entity.Task;
import itacademy.domain.entity.TypeOfJob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                new TypeOfJob(
                        resultSet.getLong("id"),
                        resultSet.getString("name")),
                new TargetOfJob(
                        resultSet.getLong("id"),
                        resultSet.getString("name")),
                new SystemUser(
                        resultSet.getLong("su_id")),
                new SystemUser(
                        resultSet.getLong("op_id")),
                new SystemUser(
                        resultSet.getLong("ex_id")));
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
                    "  ts.id,\n" +
                    "  ts.name,\n" +
                    "  p.id        as p_id,\n" +
                    "  p.name      as p_name,\n" +
                    "  ts.text,\n" +
                    "  su.id       as su_id,\n" +
                    "  su.name     as su_name,\n" +
                    "  su.family   as su_family,\n" +
                    "  su.e_mail   as su_email,\n" +
                    "  su.password as su_pass,\n" +
                    "  su.branch_id,\n" +
                    "  su.subdivision_id,\n" +
                    "  ts.executor_id as ex_id,\n" +
                    "  ts.operator_id as op_id\n" +
                    "from tasks ts, privileges p, system_users su\n" +
                    "where ts.type_of_job_id = p.id\n" +
                    "      and ts.system_user_id = su.id;";
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
}