package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.BranchDao;
import itacademy.domain.entity.Branch;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class BranchDaoImpl implements BranchDao {
    private static final Object LOCK = new Object();
    private static BranchDaoImpl INSTANCE = null;

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
                resultSet.getString("name"));
    }

    @Override
    public Optional<Branch> findById(Long id) {
        String sql = "SELECT * FROM branches br WHERE br.id = ?";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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
    public Long save(Branch branch) {
        Long id = 0L;
        String sql = "INSERT INTO branches (name) VALUES (?)";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, branch.getName());
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
    public List<Branch> findAll() {
        String sql = "SELECT * FROM branches ORDER BY name;";
        List<Branch> branches = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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
        String sql = "DELETE FROM branches WHERE (id = ?)";
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