package itacademy.services;

import itacademy.dto.SystemUserDto;

import java.util.List;

public interface SystemUserService {

    List<SystemUserDto> getAllSystemUsersDto();
}