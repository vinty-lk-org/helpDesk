package itacademy.domain.dao.impl;

import itacademy.connection.ConnectionManager;
import itacademy.domain.dao.interfaces.TaskOperatorDao;
import itacademy.dto.models.TaskOperatorDto;
import itacademy.dto.models.TaskOperatorShortDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskOperatorDaoImpl implements TaskOperatorDao {
    private static final Object LOCK = new Object();
    //    private static final String SQL_FIND_ALL_SHORT_OPERATOR = "{ ? = call  task_find_all_for_short_operator()}";
    private static final String SQL_FIND_OPERATOR_TASK_BY_ID = "select\n" +
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

    private static final String SQL_FIND_ALL_SHORT_OPERATOR = "  select\n" +
            "    t.id      as id_task,\n" +
            "    t.name    as t_name,\n" +
            "    su.name   as user_name,\n" +
            "    su.family as user_family,\n" +
            "    sd.name as subdivision,\n" +
            "    st.name as status\n" +
            "  from tasks t, system_users su, subdivisions sd, status st\n" +
            "  where t.system_user_id = su.id and t.status_id = st.id and   su.subdivision_id = sd.id  and operator_id = ?;";
    private static final String SQL_UPDATE_STATUS = "UPDATE tasks SET status_id = (?) WHERE id =(?)";
    private static final String SQL_UPDATE_EXECOTOR = "UPDATE tasks SET executor_id = (?) WHERE id =(?)";
    private static TaskOperatorDaoImpl INSTANCE = null;

    public static TaskOperatorDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskOperatorDaoImpl();
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

    public void updateExecutor(TaskOperatorDto task) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_EXECOTOR)) {
                preparedStatement.setLong(1, task.getExecutorId());
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
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_OPERATOR_TASK_BY_ID)) {
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
    public List<TaskOperatorShortDto> findAllShortOperator(Long operatorId) {
        List<TaskOperatorShortDto> operatorDto = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_SHORT_OPERATOR)) {
                preparedStatement.setLong(1, operatorId);
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