package itacademy.domain.services;

import itacademy.dto.models.BranchDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BranchServiceImplTest {

  @Test
  public void getAllBranchesDto() {
    List<BranchDto> branchDtoList = BranchServiceImpl.getInstance().getAllBranchesDto();
    Assert.assertNotNull(branchDtoList);
  }
}