package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.BranchDao;
import itacademy.domain.entity.Branch;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class BranchDaoImpl implements BranchDao {
  private static final Object LOCK = new Object();
  private static BranchDaoImpl INSTANCE = null;
  private static final String SQL_SELECT_BY_ID = "SELECT b.id, b.name, b.address FROM branches b WHERE b.id = ?;";
  private static final String SQL_DELETE_BY_ID = "DELETE FROM branches WHERE (id = ?)";
  private static final String SQL_INSERT = "INSERT INTO branches (name) VALUES (?)";
  private static final String SQL_FIND_ALL = "SELECT b.id, b.name, b.address FROM branches b ORDER BY name;;";

  public static BranchDaoImpl getInstance() {
    if (INSTANCE == null) {
      synchronized (LOCK) {
        if (INSTANCE == null) {
          INSTANCE = new BranchDaoImpl();
        }
      }
    }
    return INSTANCE;
  }

  private Branch createBranchFromResultSet(ResultSet resultSet) throws SQLException {
    return new Branch(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            resultSet.getString("address"));
  }

  @Override
  public Long save(Branch branch) {
    Long id = 0L;
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, branch.getName());
        preparedStatement.execute();
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
  public Optional<Branch> findById(Long id) {
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
        preparedStatement.setLong(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            return Optional.of(createBranchFromResultSet(resultSet));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public List<Branch> findAll() {
    List<Branch> branches = new ArrayList<>();
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
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

  @Override
  public void delete(Long id) {
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}