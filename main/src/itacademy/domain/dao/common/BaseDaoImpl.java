package itacademy.domain.dao.common;

import itacademy.connection.ConnectionManager;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private static final String TABLE_NAME = "TABLE_NAME";
    private final Class<T> modelClass;
    String fmt = "%6S:  %-12s = %s%n";
    private List<String> fieldNames;

    public BaseDaoImpl(Class<T> modelClass) {
        this.modelClass = modelClass;
        fieldNames = null;
    }

    private T createObjFromResultSet(ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        SomeContainer<T> container = new SomeContainer<>();
        T contents = container.createContents(modelClass);

        for (int i = 0; i < fieldNames.size(); i++) {
            String fieldName = fieldNames.get(i);
            Field chap = modelClass.getDeclaredField(fieldName);
            Type type = chap.getGenericType();
            if ((!fieldName.equals(TABLE_NAME)) && (type.getTypeName().equals("java.lang.Long"))) {
                chap.setAccessible(true);
                chap.set(contents, resultSet.getLong(fieldName));
            }
            if ((!fieldName.equals(TABLE_NAME)) && (type.getTypeName().equals("java.lang.String"))) {
                chap.setAccessible(true);
                chap.set(contents, resultSet.getString(fieldName));
            }
            if ((!fieldName.equals(TABLE_NAME)) && (type.getTypeName().equals("java.lang.int"))) {
                chap.setAccessible(true);
                chap.set(contents, resultSet.getInt(fieldName));
            }
            if ((!fieldName.equals(TABLE_NAME)) && (type.getTypeName().equals("java.lang.Double"))) {
                chap.setAccessible(true);
                chap.set(contents, resultSet.getDouble(fieldName));
            }
            if ((!fieldName.equals(TABLE_NAME)) && (type.getTypeName().equals("java.lang.Date"))) {
                chap.setAccessible(true);
                chap.set(contents, resultSet.getDate(fieldName));
            }
        }

        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return contents;
    }

    @Override
    public List<T> findAll() {
        fieldNames = getFieldNames();
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
            if (declaredField.getName().equals(TABLE_NAME)) {
                Field field = modelClass.getDeclaredField(TABLE_NAME);
                field.setAccessible(true);
                Class<?> t = field.getType();
                return String.valueOf(field.get(null));
            }
        }
        return null;
    }

    private List<String> getFieldNames() {
        Field[] fields = modelClass.getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

    private TypeVariable<Class<T>>[] getTypeField() {
        return modelClass.getTypeParameters();
    }

    private static class SomeContainer<T> {
        T createContents(Class<T> clazz) throws IllegalAccessException, InstantiationException {
            return clazz.newInstance();
        }
    }
}
