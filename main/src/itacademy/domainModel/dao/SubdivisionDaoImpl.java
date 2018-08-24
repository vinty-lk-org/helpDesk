package itacademy.domainModel.dao;

import itacademy.connection.ConnectionManager;
import itacademy.domainModel.dao.interfaces.SubdivisionDao;
import itacademy.domainModel.entity.Subdivision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SubdivisionDaoImpl implements SubdivisionDao {


  private Subdivision createSubdivisionFromResultSet(ResultSet resultSet) throws SQLException {
    return new Subdivision(
            resultSet.getLong("id"),
            resultSet.getString("name"));
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
}
