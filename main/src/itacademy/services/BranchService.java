package itacademy.services;

import itacademy.domain.entity.Branch;
import itacademy.dto.BranchDto;
import itacademy.dto.SystemUserDto;

import java.util.List;

public interface BranchService {

  BranchDto mapperBranch(Branch branch);
}