package itacademy.domain.services.interfaces;

import itacademy.domain.entity.Subdivision;
import itacademy.dto.models.SubdivisionDto;

import java.util.List;

public interface SubdivisionService {

  SubdivisionDto mapperSubdivision(Subdivision subdivision);

  List<SubdivisionDto> getAllSubdivisionDto();

}