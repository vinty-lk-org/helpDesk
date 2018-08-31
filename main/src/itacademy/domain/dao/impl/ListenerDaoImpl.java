package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.ListenerDao;
import itacademy.domain.entity.Listener;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListenerDaoImpl implements ListenerDao {
    public static final Object LOCK = new Object();
    private static ListenerDaoImpl INSTANCE = null;

    public static ListenerDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ListenerDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private Listener createTargetOfJobFromResultSet(ResultSet resultSet) throws SQLException {
        return new Listener(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    @Override
    public List<Listener> findAll() {
        String sql = "SELECT * FROM listeners ORDER BY name;";
        List<Listener> TargetOfJob = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        TargetOfJob.add(createTargetOfJobFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TargetOfJob;
    }

    @Override
    public Optional<Listener> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = "SELECT * FROM listeners p WHERE p.id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createTargetOfJobFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(Listener targetOfJob) {
        Long id = 0L;
        String sql = "INSERT INTO listeners (name) VALUES (?)";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, targetOfJob.getName());
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
        String sql = "DELETE FROM listeners WHERE (id = ?)";
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