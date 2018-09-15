package itacademy.domain.dao.interfaces;

import itacademy.domain.dao.common.BaseDao;
import itacademy.domain.entity.Status;

import java.util.List;

public interface StatusDao extends BaseDao {
    public List<Status> findAllStatus();

}
