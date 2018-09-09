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
    private static final String SQL_FIND_ALL = "SELECT * FROM listeners ORDER BY name;";
    private static final String SQLFIND_ID = "SELECT * FROM listeners p WHERE p.id = ?";
    private static final String SQL_SAVE = "INSERT INTO listeners (name) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM listeners WHERE (id = ?)";
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

    private Listener createLisinerFromResultSet(ResultSet resultSet) throws SQLException {
        return new Listener(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    @Override
    public List<Listener> findAll() {
        List<Listener> Listener = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Listener.add(createLisinerFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Listener;
    }

    @Override
    public Optional<Listener> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(ListenerDaoImpl.SQLFIND_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createLisinerFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(Listener Listener) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, Listener.getName());
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

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
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