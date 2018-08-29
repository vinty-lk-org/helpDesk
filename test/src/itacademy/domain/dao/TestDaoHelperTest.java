package itacademy.domain.dao;

import org.junit.Assert;
import org.junit.Test;

public class TestDaoHelperTest {

  @Test
  public void getRandomPhone() {
    String randomPhone = TestDaoHelper.getRandomPhone();
    Assert.assertEquals(15, randomPhone.length());
    String plusSymbol = "+";
    Assert.assertEquals(plusSymbol.charAt(0), randomPhone.charAt(0));
  }
}