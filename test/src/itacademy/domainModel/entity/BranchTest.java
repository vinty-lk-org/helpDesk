package itacademy.domainModel.entity;

import org.junit.Assert;
import org.junit.Test;

public class BranchTest {

  @Test
  public void createBranch() {
    Branch branch = new Branch((long) 1, "Минск");
    Assert.assertEquals("Минск", branch.getName());
    branch.setName("Минск2");
    Assert.assertEquals("Минск2", branch.getName());
  }
}