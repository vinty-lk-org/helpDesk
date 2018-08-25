package itacademy.domain.dao.interfaces;

import itacademy.domain.entity.Subdivision;

import java.util.List;
import java.util.Optional;

public interface SubdivisionDao {

  List<Subdivision> findAll();

  Optional<Subdivision> findById(Long id);

  Long save(Subdivision subdivision);

  void delete(Long id);

}
