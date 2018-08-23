package itacademy.domainModel.dao;

import itacademy.domainModel.entity.Branch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BranchDaoTest {

  @Test
  public void findAll() {
    List<Branch> branches = BranchDao.getInstance().findAll();
    Assert.assertNotNull(branches);
    System.out.println(branches);
  }
}