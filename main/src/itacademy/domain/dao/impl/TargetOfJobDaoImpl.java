package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.TargetOfJobDao;
import itacademy.domain.entity.TargetOfJob;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TargetOfJobDaoImpl implements TargetOfJobDao {
    public static final Object LOCK = new Object();
    private static itacademy.domain.dao.impl.TargetOfJobDaoImpl INSTANCE = null;

    public static itacademy.domain.dao.impl.TargetOfJobDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new itacademy.domain.dao.impl.TargetOfJobDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private TargetOfJob createTargetOfJobFromResultSet(ResultSet resultSet) throws SQLException {
        return new TargetOfJob(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    @Override
    public List<TargetOfJob> findAll() {
        String sql = "SELECT * FROM targets_of_jobs ORDER BY name;";
        List<TargetOfJob> TargetOfJob = new ArrayList<>();
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
    public Optional<TargetOfJob> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = "SELECT * FROM targets_of_jobs p WHERE p.id = ?";
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
    public Long save(TargetOfJob targetOfJob) {
        Long id = 0L;
        String sql = "INSERT INTO targets_of_jobs (name) VALUES (?)";
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
        String sql = "DELETE FROM targets_of_jobs WHERE (id = ?)";
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