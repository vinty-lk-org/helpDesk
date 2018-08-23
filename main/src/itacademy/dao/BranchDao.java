package itacademy.dao;

import itacademy.connection.ConnectionManager;
import itacademy.entity.Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDao {
  private static final String BRANCH_TABLE_NAME = "branch";
  private static final Object LOCK = new Object();
  private static BranchDao INSTANCE = null;

  public static BranchDao getInstance() {
    if (INSTANCE == null) {
      synchronized (LOCK) {
        if (INSTANCE == null) {
          INSTANCE = new BranchDao();
        }
      }
    }
    return INSTANCE;
  }

  private Branch createBranchFromResultSet(ResultSet resultSet) throws SQLException {
    return new Branch(
            resultSet.getLong("id"),
            resultSet.getString("name"));
  }

  public List<Branch> findAll() {
    List<Branch> branches = new ArrayList<>();
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(
              "SELECT * FROM branch ORDER BY name;")) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          while (resultSet.next()) {
            branches.add(createBranchFromResultSet(resultSet));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return branches;
  }
}
