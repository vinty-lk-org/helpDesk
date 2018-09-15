package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.ExecutorDao;
import itacademy.domain.entity.Listener;
import itacademy.dto.models.ExecutorAppointDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExecutorDaoImpl implements ExecutorDao {


    private static final String SQL_FIND_ALL = "select su.id, su.name, su.family\n" +
            "from system_users su\n" +
            "where su.id in\n" +
            "      (select user_id\n" +
            "       from users_privileges\n" +
            "       where privilege_id = 4);";

    private static ExecutorDaoImpl INSTANCE = null;
    private static final Object LOCK = new Object();

    private ExecutorAppointDto createExecutorFromResultSet(ResultSet resultSet) throws SQLException {
        return new ExecutorAppointDto(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("family"));
    }
    public static ExecutorDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ExecutorDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public List<ExecutorAppointDto> findAllExecutorDto() {
        List<ExecutorAppointDto> executor = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        executor.add(createExecutorFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executor;
    }

    @Override
    public Long save(Object entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }
}