package itacademy.domainModel.dao;

import itacademy.domainModel.entity.Branch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BranchDaoImplTest {

  @Test
  public void findAllTest() {
    List<Branch> branches = BranchDaoImpl.getInstance().findAll();
    Assert.assertNotNull(branches);
    System.out.println(branches);
  }

  @Test
  public void findByIdTest() {
    Branch myBranch = new Branch("Минский фил 01");
    Long aLong = BranchDaoImpl.getInstance().save(myBranch);
    Branch branch = BranchDaoImpl.getInstance().findById(aLong);
    Assert.assertEquals(aLong, branch.getId());
  }

  @Test
  public void deleteForIdTest() {
    List<Branch> branches = BranchDaoImpl.getInstance().findAll();
    Assert.assertNotNull(branches);
    System.out.println(branches);
  }

  @Test
  public void saveTest() {

  }
}