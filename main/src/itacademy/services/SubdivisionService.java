package itacademy.services;

import itacademy.domain.entity.Subdivision;
import itacademy.dto.SubdivisionDto;

import java.util.List;

public interface SubdivisionService {

  SubdivisionDto mapperSubdivision(Subdivision subdivision);

  List<SubdivisionDto> getAllSubdivisionDto();

}