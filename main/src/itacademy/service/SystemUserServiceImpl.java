package itacademy.service;

import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.domain.entity.SystemUser;
import itacademy.dto.SystemUserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SystemUserServiceImpl implements SystemUserService{
  private static final Object LOCK = new Object();
  private static SystemUserServiceImpl INSTANCE = null;
  public static SystemUserServiceImpl getInstance() {
      if (INSTANCE == null) {
          synchronized (LOCK) {
              if (INSTANCE == null) {
                  INSTANCE = new SystemUserServiceImpl();
              }
          }
      }
      return INSTANCE;
  }

  private SystemUserServiceImpl() {
  }

  @Override
  public List<SystemUserDto> getAllSystemUsersDto() {
    return mapper(SystemUserDaoImpl.getInstance().findAll());
  }

  private List<SystemUserDto> mapper(List<SystemUser> systemUsersList) {
    return systemUsersList.stream()
     .map(systemUser -> new SystemUserDto(
             systemUser.getId(),
             systemUser.getName(),
             systemUser.getFamaly(),
             systemUser.getEmail(),
             systemUser.getPassword(),
             systemUser.getBranchId().getName(),
             systemUser.getSubdivisionId().getName()
     ))
     .collect(Collectors.toList());
  }
}
