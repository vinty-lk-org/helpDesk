package itacademy.domain.services;

import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.domain.entity.Subdivision;
import itacademy.domain.entity.SystemUser;
import itacademy.dto.models.SystemUserDto;
import itacademy.domain.services.interfaces.SystemUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SystemUserServiceImpl implements SystemUserService {
  private static final Object LOCK = new Object();
  private static SystemUserServiceImpl INSTANCE = null;

  private SystemUserServiceImpl() {
  }

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

  @Override
  public List<SystemUserDto> getAllSystemUsersDto() {
    return mapperListSystemUserToDto(SystemUserDaoImpl.getInstance().findAll());
  }

  @Override
  public SystemUserDto getSystemUserById(Long id) {
    Optional<SystemUser> userOptional = SystemUserDaoImpl.getInstance().findById(id);
    return userOptional.map(this::mapperSystemUserToDto).orElse(null);
  }

  @Override
  public Long saveUser(SystemUserDto systemUserDto) {
    return SystemUserDaoImpl.getInstance().save(mapperSystemUserDtoToSystemUser(systemUserDto));
  }

  private SystemUserDto mapperSystemUserToDto(SystemUser systemUser) {
    return new SystemUserDto(
                    systemUser.getId(),
                    systemUser.getName(),
                    systemUser.getFamily(),
                    systemUser.getEmail(),
                    systemUser.getPassword(),
                    systemUser.getBranch().getId(),
                    systemUser.getBranch().getName(),
                    systemUser.getSubdivision().getId(),
                    systemUser.getSubdivision().getName());
  }

  private List<SystemUserDto> mapperListSystemUserToDto(List<SystemUser> systemUsersList) {
    return systemUsersList.stream()
            .map(systemUser -> new SystemUserDto(
                    systemUser.getId(),
                    systemUser.getName(),
                    systemUser.getFamily(),
                    systemUser.getEmail(),
                    systemUser.getPassword(),
                    systemUser.getBranch().getId(),
                    systemUser.getBranch().getName(),
                    systemUser.getSubdivision().getId(),
                    systemUser.getSubdivision().getName()
            ))
            .collect(Collectors.toList());
  }

  private SystemUser mapperSystemUserDtoToSystemUser(SystemUserDto userDto) {
    return new SystemUser(
            userDto.getName(),
            userDto.getFamily(),
            userDto.getEmail(),
            userDto.getPassword(),
            new Branch(userDto.getBranchId()),
            new Subdivision(userDto.getSubdivisionId()));
  }

  public SystemUser findByEmail(String email) {
    SystemUser systemUser = new SystemUser();
    Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findByEmail(email);
    if (optionalSystemUser.isPresent()) {
      systemUser = optionalSystemUser.get();
    }
    return systemUser;
  }

  public boolean isEmail(String email) {
    SystemUser systemUser = new SystemUser();
    Optional<SystemUser> optionalSystemUser = SystemUserDaoImpl.getInstance().findByEmail(email);
    if (optionalSystemUser.isPresent()) {
      return true;
    }
    return false;
  }
}
