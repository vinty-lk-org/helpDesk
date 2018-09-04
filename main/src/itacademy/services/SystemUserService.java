package itacademy.services;

import itacademy.domain.entity.SystemUser;
import itacademy.dto.SystemUserDto;

import java.util.List;

public interface SystemUserService {

  List<SystemUserDto> getAllSystemUsersDto();

  Long saveUser(SystemUserDto systemUserDto);

  SystemUser findByEmail(String email);

  boolean isEmail(String email);

}