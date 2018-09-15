package itacademy.domain.dao.impl;


import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.CategoryDao;
import itacademy.domain.entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CategoryDaoImpl implements CategoryDao {
    public static final Object LOCK = new Object();
    private static final String SQL_FIND_ALL = "SELECT * FROM category ORDER BY name;";

    private static final String SQL_SAVE = "INSERT INTO category (name) VALUES (?)";

    private static final String SQL_DELETE = "DELETE FROM category WHERE (id = ?)";
    private static CategoryDaoImpl INSTANCE = null;

     public static CategoryDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private Category createCategoryFromResultSet(ResultSet resultSet) throws SQLException {
        return new Category(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    public Long saveDao(Category Category) {
        Long id = 0L;
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, Category.getName());
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

    private static final String SQL_UPDATE = "UPDATE category SET name = (?) WHERE id =(?)";
    public void update(Category category) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
                preparedStatement.setString(1, category.getName());
                preparedStatement.setLong(2, category.getId());
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
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
    public List<Category> findAll() {
        List<Category> Category = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Category.add(createCategoryFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Category;
    }

    private static final String SQL_FIND_ID = "SELECT * FROM category p WHERE p.id = ?";
    @Override
    public Optional<Category> findById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createCategoryFromResultSet(resultSet));
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