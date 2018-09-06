package itacademy.services;

import itacademy.domain.dao.TestDaoHelper;
import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.dao.impl.SubdivisionDaoImpl;
import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.dto.SystemUserDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SystemUserServiceImplTest {

  @Test
  public void getAllSystemUsersDto() {
    List<SystemUserDto> allSystemUsersDto = SystemUserServiceImpl.getInstance().getAllSystemUsersDto();
    Assert.assertNotNull(allSystemUsersDto);
  }

  @Test
  public void saveUserTest() {
    Long id = SystemUserServiceImpl.getInstance().saveUser(new SystemUserDto(
            SystemUserDto.builder()
                    .name(TestDaoHelper.getRandomWord(4, 10, true))
                    .family(TestDaoHelper.getRandomWord(4, 10, true))
                    .email(TestDaoHelper.getRandomEmail())
                    .password(TestDaoHelper.getRandomWord(6, 10, false))
                    .branchId(TestDaoHelper.getRandomIdFromList(BranchDaoImpl.getInstance().findAll()))
                    .subdivisionId((Long) TestDaoHelper.getRandomIdFromList(SubdivisionDaoImpl.getInstance().findAll()))
                    .build()));
    Assert.assertNotNull(id);
    Assert.assertNotNull(SystemUserDaoImpl.getInstance().findById(id));
    SystemUserDaoImpl.getInstance().delete(id);
  }

  @Test
  public void isEmail() {
    String randomEmail = TestDaoHelper.getRandomEmail();
    Long id = SystemUserServiceImpl.getInstance().saveUser(new SystemUserDto(
            SystemUserDto.builder()
                    .name(TestDaoHelper.getRandomWord(4, 10, true))
                    .family(TestDaoHelper.getRandomWord(4, 10, true))
                    .email(randomEmail)
                    .password(TestDaoHelper.getRandomWord(6, 10, false))
                    .branchId(TestDaoHelper.getRandomIdFromList(BranchDaoImpl.getInstance().findAll()))
                    .subdivisionId((Long) TestDaoHelper.getRandomIdFromList(SubdivisionDaoImpl.getInstance().findAll()))
                    .build()));
    Assert.assertNotNull(id);
    boolean email = SystemUserServiceImpl.getInstance().isEmail(randomEmail);
    Assert.assertTrue(email);
    SystemUserDaoImpl.getInstance().delete(id);
  }
}