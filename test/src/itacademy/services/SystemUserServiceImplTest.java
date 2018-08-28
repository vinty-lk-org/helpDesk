package itacademy.services;

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
}