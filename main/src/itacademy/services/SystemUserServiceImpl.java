package itacademy.services;

import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.domain.entity.SystemUser;
import itacademy.dto.SystemUserDto;

import java.util.List;
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
        List<SystemUserDto> mapper = mapper(SystemUserDaoImpl.getInstance().findAll());
        return mapper;
    }

    private List<SystemUserDto> mapper(List<SystemUser> systemUsersList) {
        return systemUsersList.stream()
                .map(systemUser -> new SystemUserDto(
                        systemUser.getId(),
                        systemUser.getName(),
                        systemUser.getFamily(),
                        systemUser.getEmail(),
                        systemUser.getPassword(),
                        systemUser.getBranch().getName(),
                        systemUser.getSubdivision().getName()
                ))
                .collect(Collectors.toList());
    }
}
