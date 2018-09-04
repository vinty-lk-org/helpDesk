package itacademy.domain.dao.common;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {

  Long save(T entity);

  void delete(Long id);

  List<T> findAll();

  Optional<T> findById(Long id);

}
