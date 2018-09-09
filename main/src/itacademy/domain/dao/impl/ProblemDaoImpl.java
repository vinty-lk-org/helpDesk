package itacademy.domain.dao.impl;


import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.ProblemDao;
import itacademy.domain.entity.Problem;
import itacademy.domain.entity.SystemUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProblemDaoImpl implements ProblemDao {
    public static final Object LOCK = new Object();
    private static final String SQL_FIND_ALL = "SELECT * FROM problems ORDER BY name;";
    private static final String SQLFIND_ID = "SELECT * FROM problems p WHERE p.id = ?";
    private static final String SQL_SAVE = "INSERT INTO problems (name) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM problems WHERE (id = ?)";
    private static ProblemDaoImpl INSTANCE = null;

    public static ProblemDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ProblemDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private Problem createProblemFromResultSet(ResultSet resultSet) throws SQLException {
        return new Problem(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    public Long saveDao(Problem Problem) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, Problem.getName());
                preparedStatement.executeUpdate();
                connection.commit();

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
            try (PreparedStatement preparedStatement = (connection.prepareStatement(SQL_DELETE))) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Problem> findAll() {
        List<Problem> Problem = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Problem.add(createProblemFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Problem;
    }

    @Override
    public Optional<Problem> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(ProblemDaoImpl.SQLFIND_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createProblemFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Long save(Object entity) {
        return null;
    }

}