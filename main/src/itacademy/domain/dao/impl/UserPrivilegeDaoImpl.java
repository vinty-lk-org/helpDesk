package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.PrivilegeDao;
import itacademy.domain.dao.interfaces.UserPrivilegeDao;
import itacademy.domain.entity.Privilege;
import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.UserPrivilege;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserPrivilegeDaoImpl implements UserPrivilegeDao {
    public static final Object LOCK = new Object();
    private static final String SQL_FIND_ALL_BY_USER_ID = "SELECT * FROM users_privileges where user_id = ?;";
    private static UserPrivilegeDaoImpl INSTANCE = null;

    public static UserPrivilegeDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserPrivilegeDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private UserPrivilege createUsersPrivilegesFromResultSet(ResultSet resultSet) throws SQLException {
        return new UserPrivilege(
                new SystemUser(resultSet.getLong("user_id")),
                new Privilege(resultSet.getLong("privilege_id")));
    }

    @Override
    public List<UserPrivilege> findAllByUserId(Long id) {
        List<UserPrivilege> privileges = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_USER_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        privileges.add(createUsersPrivilegesFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privileges;
    }
}