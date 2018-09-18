package itacademy.domain.dao.interfaces;

import itacademy.domain.dao.common.*;
import itacademy.dto.models.*;

import java.util.*;

public interface TaskExecutorDao extends BaseDao {

    public List<TaskOperatorShortDto> findAllShortExecutor (Long operatorId);
}
