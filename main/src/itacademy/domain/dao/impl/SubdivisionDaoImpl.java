package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.SubdivisionDao;
import itacademy.domain.entity.Subdivision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubdivisionDaoImpl implements SubdivisionDao {
  private static final Object LOCK = new Object();
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
      String sql = "SELECT * FROM subdivisions ORDER BY name";
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          while (resultSet.next()){
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
      String sql = "SELECT * FROM subdivisions s WHERE s.id = ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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
    String sql = "INSERT INTO subdivisions (name) VALUES (?)";
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, subdivision.getName());
        preparedStatement.executeUpdate();
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
    String sql = "DELETE FROM subdivisions WHERE (id = ?)";
    try (Connection connection = ConnectionManager.getConnection()) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

