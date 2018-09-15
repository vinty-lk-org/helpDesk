package itacademy.domain.dao.interfaces;

import itacademy.domain.dao.common.BaseDao;
import itacademy.dto.models.TaskOperatorShortDto;

import java.util.List;

public interface TaskOperatorDao extends BaseDao {

    public List<TaskOperatorShortDto> findAllShortOperator(Long operatorId);
}
