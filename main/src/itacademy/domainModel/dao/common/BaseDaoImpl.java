package itacademy.domainModel.dao.common;

import itacademy.connection.ConnectionManager;
import itacademy.dto.db.TargetOfJobDto;

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

    public BaseDaoImpl(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    //  private static class SomeContainer<T> {
    //    T createContents(Class<T> clazz) {
    //      try {
    //        return clazz.newInstance();
    //      } catch (InstantiationException | IllegalAccessException e) {
    //        e.printStackTrace();
    //      }
    //      return null;
    //    }
    //  }
//    class SomeContainer<T> {
//        private Supplier<T> supplier;
//
//        SomeContainer(Supplier<T> supplier) {
//            this.supplier = supplier;
//        }
//
//        T createContents() {
//            return supplier.get();
//        }
//    }

    private static class SomeContainer<T> {
        T createContents(Class<T> clazz) throws IllegalAccessException, InstantiationException {
            return clazz.newInstance();
        }
    }


    private T createObjFromResultSet(ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException {
        SomeContainer<T> container = new SomeContainer<>();
        T contents = container.createContents((Class<T>) TargetOfJobDto.class);
        System.out.println(contents);
        resultSet.getString("name");
        return contents;
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
                        System.out.println(createObjFromResultSet(resultSet));
                        list.add((T) createObjFromResultSet(resultSet));
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void delete(Long id) {

    }

    private String getTableName() throws NoSuchFieldException, IllegalAccessException {
        Field[] declaredFields = modelClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getName().equals("TABLE_NAME")) {
                Field field = modelClass.getDeclaredField("TABLE_NAME");
                field.setAccessible(true);
                Class<?> t = field.getType();
                if (t == String.class) {
                    return String.valueOf(field.get(null));
                }
            }
        }
        return null;
    }
}
