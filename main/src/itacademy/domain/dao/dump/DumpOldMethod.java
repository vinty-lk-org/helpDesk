package itacademy.domain.dao.dump;

import itacademy.connection.ConnectionManager;
import itacademy.domain.entity.SystemUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DumpOldMethod {


    //    @Override
//    public Optional<SystemUser> findById(Long id) {
//        String sql = "select\n" +
//                "  su.id,\n" +
//                "  su.name,\n" +
//                "  su.family,\n" +
//                "  su.e_mail,\n" +
//                "  su.password,\n" +
//                "  b.id as b_id,\n" +
//                "  b.name as b_name,\n" +
//                "  b.address as b_adress,\n" +
//                "  s.id as s_id,\n" +
//                "  s.name as s_name\n" +
//                "from system_users su, branches b, subdivisions s\n" +
//                "where su.branch_id = b.id\n" +
//                "      and su.subdivision_id = s.id" +
//                "      and su.id = ? ;";
//        try (Connection connection = ConnectionManager.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setLong(1, id);
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    if (resultSet.next()) {
//                        return Optional.of(createSystemUserFromResultSet(resultSet));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }


//    public List<SystemUser> findAll() {
//        List<SystemUser> systemUsersList = new ArrayList<>();
//        try (Connection connection = ConnectionManager.getConnection()) {
//            String sql = "select\n" +
//                    "  su.id,\n" +
//                    "  su.name,\n" +
//                    "  su.family,\n" +
//                    "  su.e_mail,\n" +
//                    "  su.password,\n" +
//                    "  b.id as b_id,\n" +
//                    "  b.name as b_name,\n" +
//                    "  b.address as b_address,\n" +
//                    "  s.id as s_id,\n" +
//                    "  s.name as s_name\n" +
//                    "from system_users su, branches b, subdivisions s\n" +
//                    "where su.branch_id = b.id\n" +
//                    "      and su.subdivision_id = s.id;";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    while (resultSet.next()) {
//                        systemUsersList.add(createSystemUserFromResultSet(resultSet));
//                    }
//                }
//            }
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
//        return systemUsersList;
//    }



//    public Optional<SystemUser> findById(Long id) {
//        String sql = "select\n" +
//                "  su.id,\n" +
//                "  su.name,\n" +
//                "  su.family,\n" +
//                "  su.e_mail,\n" +
//                "  su.password,\n" +
//                "  b.id as b_id,\n" +
//                "  b.name as b_name,\n" +
//                "  b.address as b_address,\n" +
//                "  s.id as s_id,\n" +
//                "  s.name as s_name\n" +
//                "from system_users su, branches b, subdivisions s\n" +
//                "where su.branch_id = b.id\n" +
//                "      and su.subdivision_id = s.id" +
//                "      and su.id = ? ;";
//        try (Connection connection = ConnectionManager.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setLong(1, id);
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    if (resultSet.next()) {
//                        return Optional.of(createSystemUserFromResultSet(resultSet));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }



    //  @Override
//  public Long save(SystemUser entity) {
//    Long id = 0L;
//    String SQL = "{call system_user_save(?, ?, ?, ?, ?, ?)}";
//    try (Connection connection = ConnectionManager.getConnection();
//         CallableStatement callableStatement = connection.prepareCall(SQL)) {
//      connection.setAutoCommit(false);
//      callableStatement.setString(1, entity.getName());
//      callableStatement.setString(2, entity.getFamily());
//      callableStatement.setString(3, entity.getEmail());
//      callableStatement.setString(4, entity.getPassword());
//      callableStatement.setLong(5, entity.getBranch().getId());
//      callableStatement.setLong(6, entity.getSubdivision().getId());
////      String.valueOf(Statement.RETURN_GENERATED_KEYS);
//      callableStatement.execute();
//      ResultSet generatedKeys = callableStatement.getGeneratedKeys();
//      if (generatedKeys.next()){
//        return generatedKeys.getLong(1);
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return id;
//  }

}
