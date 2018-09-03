package itacademy.services;

import itacademy.domain.dao.impl.SubdivisionDaoImpl;
import itacademy.domain.entity.Subdivision;
import itacademy.dto.SubdivisionDto;

import java.util.List;
import java.util.stream.Collectors;

public class SubdivisionServiceImpl implements SubdivisionService {
  private static final Object LOCK = new Object();
  private static SubdivisionServiceImpl INSTANCE = null;
  public static SubdivisionServiceImpl getInstance() {
      if (INSTANCE == null) {
          synchronized (LOCK) {
              if (INSTANCE == null) {
                  INSTANCE = new SubdivisionServiceImpl();
              }
          }
      }
      return INSTANCE;
  }

  @Override
  public SubdivisionDto mapperSubdivision(Subdivision subdivision) {
    return new SubdivisionDto(subdivision.getId(), subdivision.getName());
  }

  @Override
  public List<SubdivisionDto> getAllSubdivisionDto() {
    return SubdivisionDaoImpl.getInstance().findAll()
            .stream()
            .map(this::mapperSubdivision)
            .collect(Collectors.toList());
  }
}
