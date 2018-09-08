package itacademy.domain.dao.interfaces;

import itacademy.domain.dao.common.BaseDao;
import itacademy.domain.entity.Task;

import java.util.List;

public interface TaskDao extends BaseDao<Task> {

    List<Task> findSelfTasks(Long id);

}