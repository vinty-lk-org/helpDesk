package itacademy.domain.dao.impl;

import itacademy.connection.*;
import itacademy.domain.dao.interfaces.*;
import itacademy.dto.models.*;

import java.sql.*;
import java.util.*;

public class TaskExecutorDaoImpl implements TaskExecutorDao {
    private static final Object LOCK = new Object();
    //    private static final String SQL_FIND_ALL_SHORT_OPERATOR = "{ ? = call  task_find_all_for_short_operator()}";
    private static final String SQL_FIND_EXECUTOR_TASK_BY_ID = "select\n" +
            "  t.id      as t_id,\n" +
            "  t.name    as t_name,\n" +
            "    t.text,\n" +
            "  t.system_user_id,\n" +
            "  su.name   as su_name,\n" +
            "  su.family as su_family,\n" +
            "  su.subdivision_id,\n" +
            "  sd.name as sd_name,\n" +
            "  t.status_id,\n" +
            "  st.name as status,\n" +
            "  t.executor_id,\n" +
            "  t.operator_id\n" +
            "\n" +
            "from tasks t, system_users su, subdivisions sd, status st\n" +
            "where t.system_user_id = su.id and t.status_id = st.id and su.subdivision_id = sd.id  and t.id = ?;";

    private static final String SQL_FIND_ALL_SHORT_EXECUTOR = "select\n" +
            "  t.id      as id_task,\n" +
            "  t.name    as t_name,\n" +
            "  su.name   as user_name,\n" +
            "  su.family as user_family,\n" +
            "  sd.name   as subdivision,\n" +
            "  st.name   as status\n" +
            "from tasks t, system_users su, subdivisions sd, status st\n" +
            "where t.system_user_id = su.id and t.status_id = st.id and su.subdivision_id = sd.id and executor_id = ?;";




    private static final String SQL_FIND_ALL_STATUS_SUBMITET_EXECUTOR = "select\n" +
            "  t.id      as id_task,\n" +
            "  t.name    as t_name,\n" +
            "  su.name   as user_name,\n" +
            "  su.family as user_family,\n" +
            "  sd.name   as subdivision,\n" +
            "  st.name   as status\n" +
            "from tasks t, system_users su, subdivisions sd, status st\n" +
            "where t.system_user_id = su.id" +
            " and t.status_id = st.id and " +
            "su.subdivision_id = sd.id  and" +
            " executor_id = ? and status_id = 2;";

    private static final String SQL_UPDATE_STATUS = "UPDATE tasks SET status_id = (?) WHERE id =(?)";

    private static TaskExecutorDaoImpl INSTANCE = null;

    public static TaskExecutorDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskExecutorDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    private TaskOperatorDto createFindAllFromOperatorTask(ResultSet resultSet) throws SQLException {
        return new TaskOperatorDto(
                resultSet.getLong("t_id"),
                resultSet.getString("t_name"),
                resultSet.getString("text"),
                resultSet.getLong("system_user_id"),
                resultSet.getString("su_name"),
                resultSet.getString("su_family"),
                resultSet.getLong("subdivision_id"),
                resultSet.getString("sd_name"),
                resultSet.getLong("status_id"),
                resultSet.getString("status"),
                resultSet.getLong("executor_id"),
                resultSet.getLong("operator_id"));
    }

    private TaskOperatorShortDto createFindAllFromOperatorShortTask(ResultSet resultSet) throws SQLException {
        return new TaskOperatorShortDto(
                resultSet.getLong("id_task"),
                resultSet.getString("t_name"),
                resultSet.getString("user_name"),
                resultSet.getString("user_family"),
                resultSet.getString("subdivision"),
                resultSet.getString("status"));
    }

    public void updateStatus(TaskOperatorDto task) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_STATUS)) {
                preparedStatement.setLong(1, task.getStatusId());
                preparedStatement.setLong(2, task.getTaskId());
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Optional<TaskOperatorDto> findByIdOperatorTask(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_EXECUTOR_TASK_BY_ID)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createFindAllFromOperatorTask(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TaskOperatorShortDto> findAllShortExecutor(Long executorId) {
        List<TaskOperatorShortDto> operatorDto = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_SHORT_EXECUTOR)) {
                preparedStatement.setLong(1, executorId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        operatorDto.add(createFindAllFromOperatorShortTask(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operatorDto;
    }

        public List<TaskOperatorShortDto> findAllShortExecutorStatus(Long executorId) {
        List<TaskOperatorShortDto> operatorDto = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_STATUS_SUBMITET_EXECUTOR)) {
                preparedStatement.setLong(1, executorId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        operatorDto.add(createFindAllFromOperatorShortTask(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operatorDto;
    }

    @Override
    public Long save(Object entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

}