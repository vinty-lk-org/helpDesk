package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.StatusDao;
import itacademy.domain.entity.Branch;
import itacademy.domain.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StatusDaoImpl implements StatusDao {

    private static final Object LOCK = new Object();
    private static StatusDaoImpl INSTANCE = null;

    public static StatusDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new StatusDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private Status createBranchFromResultSet(ResultSet resultSet) throws SQLException {
        return new Status(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }
    private static final String SQL_FIND_ALL = "SELECT * FROM status;";
    @Override
    public List<Status> findAllStatus() {
        List<Status> statuses = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        statuses.add(createBranchFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
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
