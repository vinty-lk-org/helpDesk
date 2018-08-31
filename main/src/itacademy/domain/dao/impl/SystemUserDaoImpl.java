package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.SystemUserDao;
import itacademy.domain.entity.Branch;
import itacademy.domain.entity.Subdivision;
import itacademy.domain.entity.SystemUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SystemUserDaoImpl implements SystemUserDao {
    private static final Object LOCK = new Object();
    private static final String SQL_FIND_ALL = "{ ? = call system_user_find_all()}";
    private static final String SQL_FIND_ID = "{ ? = call system_user_findbyid(?)}";
    private static final String SQL_SAVE = "INSERT INTO system_users (name, family, e_mail, password, branch_id, subdivision_id)" + "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SQL_DELETE = "DELETE FROM system_users WHERE (id = ?)";
    private static final String SQL_FIND_EMAIL = "{ ? = call system_user_findby_email(?)}";
    private static SystemUserDaoImpl INSTANCE = null;
    private static String SYSTEM_USERS = "system_users";
    private static String BRANCHES = "branches";
    private static String SUBDIVISIONS = "subdivisions";

    public static SystemUserDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new SystemUserDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private SystemUser createSystemUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new SystemUser(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("family"),
                resultSet.getString("e_mail"),
                resultSet.getString("password"),
                new Branch(
                        resultSet.getLong("b_id"),
                        resultSet.getString("b_name"),
                        resultSet.getString("b_address")),
                new Subdivision(
                        resultSet.getLong("s_id"),
                        resultSet.getString("s_name")));
    }

    @Override
    public List<SystemUser> findAll() {
        List<SystemUser> SystemUserList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(SQL_FIND_ALL)) {
            connection.setAutoCommit(false);
            proc.registerOutParameter(1, Types.OTHER);
            proc.execute();
            ResultSet resultSet = (ResultSet) proc.getObject(1);
            while (resultSet.next()) {
                SystemUserList.add(createSystemUserFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SystemUserList;
    }

    @Override
    public Optional<SystemUser> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(SQL_FIND_ID)) {
            connection.setAutoCommit(false);
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2, Math.toIntExact(id));
            proc.execute();
            ResultSet resultSet = (ResultSet) proc.getObject(1);
            while (resultSet.next()) {
                return Optional.of(createSystemUserFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(SystemUser entity) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, entity.getName());
                preparedStatement.setString(2, entity.getFamaly());
                preparedStatement.setString(3, entity.getEmail());
                preparedStatement.setString(4, entity.getPassword());
                preparedStatement.setLong(5, entity.getBranch().getId());
                preparedStatement.setLong(6, entity.getSubdivision().getId());
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
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<SystemUser> findByEmail(String email) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(SQL_FIND_EMAIL)) {
            connection.setAutoCommit(false);
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2, email);
            proc.execute();
            ResultSet resultSet = (ResultSet) proc.getObject(1);
            while (resultSet.next()) {
                return Optional.of(createSystemUserFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}