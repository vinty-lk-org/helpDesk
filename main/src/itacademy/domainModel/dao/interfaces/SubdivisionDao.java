package itacademy.domainModel.dao.interfaces;

import itacademy.domainModel.entity.Subdivision;

import java.util.Optional;

public interface SubdivisionDao {

  Optional<Subdivision> findById(Long id);

  Long save(Subdivision subdivision);

  void delete(Long id);

}
