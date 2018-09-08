package itacademy.domain.services.interfaces;

import itacademy.domain.entity.Branch;
import itacademy.dto.models.BranchDto;

import java.util.List;

public interface BranchService {
  BranchDto mapperBranch(Branch branch);

  List<BranchDto> getAllBranchesDto();

}