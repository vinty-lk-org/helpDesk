package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.PrivilegeDao;
import itacademy.domain.entity.Privilege;
import itacademy.domain.entity.SystemUser;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class PrivilegeDaoImpl implements PrivilegeDao {
    public static final Object LOCK = new Object();
    private static final String SQL_FIND_ALL = "SELECT * FROM privileges ORDER BY name;";
    private static final String SQL_FIND_ID = "SELECT * FROM privileges p WHERE p.id = ?";
    private static final String SQL_SAVE = "INSERT INTO privileges (name) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM privileges WHERE (id = ?)";
    private static PrivilegeDaoImpl INSTANCE = null;

    public static PrivilegeDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PrivilegeDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private Privilege createPrivilegeFromResultSet(ResultSet resultSet) throws SQLException {
        return new Privilege(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    @Override
    public List<Privilege> findAll() {
        List<Privilege> privileges = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        privileges.add(createPrivilegeFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privileges;
    }

    @Override
    public Optional<Privilege> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createPrivilegeFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(Privilege privilege) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, privilege.getName());
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
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = (connection.prepareStatement(SQL_DELETE))) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}