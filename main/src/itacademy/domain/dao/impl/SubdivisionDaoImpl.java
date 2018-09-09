package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.SubdivisionDao;
import itacademy.domain.entity.Subdivision;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubdivisionDaoImpl implements SubdivisionDao {
    private static final Object LOCK = new Object();
    private static final String SQL_FIND_ALL = "SELECT * FROM subdivisions ORDER BY name";
    private static final String SQL_FIND_ID = "SELECT * FROM subdivisions s WHERE s.id = ?";
    private static final String SQL_SAVE = "INSERT INTO subdivisions (name) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM subdivisions WHERE (id = ?)";
    private static SubdivisionDaoImpl INSTANCE = null;

    public static SubdivisionDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new SubdivisionDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private Subdivision createSubdivisionFromResultSet(ResultSet resultSet) throws SQLException {
        return new Subdivision(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    @Override
    public List<Subdivision> findAll() {
        List<Subdivision> subdivisionList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        subdivisionList.add(createSubdivisionFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subdivisionList;
    }

    @Override
    public Optional<Subdivision> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createSubdivisionFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(Subdivision subdivision) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, subdivision.getName());
                preparedStatement.executeUpdate();
                connection.commit();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}