package itacademy.domain.dao.common;

import java.util.List;

public interface BaseDao<T> {

    void save(T entity);

    void  delete(Long id);

    List<T> findAll();

    T findById(Long id);

}
