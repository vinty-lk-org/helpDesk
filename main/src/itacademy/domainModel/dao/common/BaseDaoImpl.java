package itacademy.domainModel.dao.common;

import itacademy.connection.ConnectionManager;
import sun.security.jca.GetInstance;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

  private ConnectionManager connectionManager;
  private final Class<T> modelClass;

  private String getTableName() throws NoSuchFieldException, IllegalAccessException {
    Field[] declaredFields = modelClass.getDeclaredFields();
    for (int i = 0; i < declaredFields.length; i++) {
      if (declaredFields[i].getName().equals("TABLE_NAME")) {
        Field field = modelClass.getDeclaredField("TABLE_NAME");
        field.setAccessible(true);
        Class<?> t = field.getType();
        if (t == String.class) {
          return String.valueOf(field.get(null));
        }
      }
    }return null;
  }

  public BaseDaoImpl(Class<T> modelClass) {
    this.modelClass = modelClass;
  }

  @Override
  public void save(T entity) {

  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<T> findAll() {
    List<T> list = new ArrayList<>();
    try (Connection connection = ConnectionManager.getConnection()) {
      String sql = "SELECT * FROM " + getTableName() + ";";
      System.out.println(sql);
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          while (resultSet.next()) {
            System.out.println("--------------");
                list.add((T) modelClass);
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public T findById(Long id) {
    return null;
  }
}
