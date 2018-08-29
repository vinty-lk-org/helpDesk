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
                        resultSet.getString("b_adress")),
                new Subdivision(
                        resultSet.getLong("s_id"),
                        resultSet.getString("s_name")));
    }

    @Override
    public Long save(SystemUser entity) {
        Long id = 0L;
        String sql = "INSERT INTO system_users (name, family, e_mail, password, branch_id, subdivision_id)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
        String sql = "DELETE FROM system_users WHERE (id = ?)";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SystemUser> findAll() {
        List<SystemUser> systemUsersList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = "select\n" +
                    "  su.id,\n" +
                    "  su.name,\n" +
                    "  su.family,\n" +
                    "  su.e_mail,\n" +
                    "  su.password,\n" +
                    "  b.id as b_id,\n" +
                    "  b.name as b_name,\n" +
                    "  b.adress as b_adress,\n" +
                    "  s.id as s_id,\n" +
                    "  s.name as s_name\n" +
                    "from system_users su, branches b, subdivisions s\n" +
                    "where su.branch_id = b.id\n" +
                    "      and su.subdivision_id = s.id;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        systemUsersList.add(createSystemUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return systemUsersList;
    }

    @Override
    public Optional<SystemUser> findById(Long id) {
        String sql = "select\n" +
                "  su.id,\n" +
                "  su.name,\n" +
                "  su.family,\n" +
                "  su.e_mail,\n" +
                "  su.password,\n" +
                "  b.id as b_id,\n" +
                "  b.name as b_name,\n" +
                "  b.adress as b_adress,\n" +
                "  s.id as s_id,\n" +
                "  s.name as s_name\n" +
                "from system_users su, branches b, subdivisions s\n" +
                "where su.branch_id = b.id\n" +
                "      and su.subdivision_id = s.id" +
                "      and su.id = ? ;";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createSystemUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<SystemUser> findByIdPrc(Long id) {
        String sql = "{ ? = call system_user_findbyid(?)}";
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(sql)) {
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

    public Optional<SystemUser> findByEmail (String email) {
        String sql = "{ ? = call system_user_findby_email(?)}";
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement proc = connection.prepareCall(sql)) {
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

    public Optional<SystemUser> findByemail2(String email) {
        String sql = "select\n" +
                "  su.id,\n" +
                "  su.name,\n" +
                "  su.family,\n" +
                "  su.e_mail,\n" +
                "  su.password,\n" +
                "  b.id as b_id,\n" +
                "  b.name as b_name,\n" +
                "  b.adress as b_adress,\n" +
                "  s.id as s_id,\n" +
                "  s.name as s_name\n" +
                "from system_users su, branches b, subdivisions s\n" +
                "where su.branch_id = b.id\n" +
                "      and su.subdivision_id = s.id" +
                "      and su.e_mail = ? ;";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createSystemUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
