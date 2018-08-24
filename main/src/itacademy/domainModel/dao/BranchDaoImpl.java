package itacademy.domainModel.dao;

import itacademy.connection.ConnectionManager;
import itacademy.domainModel.dao.interfaces.BranchDao;
import itacademy.domainModel.entity.Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
    //  private static final String BRANCH_TABLE_NAME = "branch";
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
    public Branch findById(Long id) {
        return null;
    }

    @Override
    public Long save(Branch branch) {
        return 0L;
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