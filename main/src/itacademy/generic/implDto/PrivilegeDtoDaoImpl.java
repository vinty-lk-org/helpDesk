package itacademy.generic.implDto;

import itacademy.generic.BaseDaoImpl;
import itacademy.generic.interfacesDto.PrivilegeDtoDao;
import itacademy.generic.db.PrivilegeDto;

public class PrivilegeDtoDaoImpl extends BaseDaoImpl<PrivilegeDto> implements PrivilegeDtoDao {

    public PrivilegeDtoDaoImpl(Class<PrivilegeDto> modelClass) {
        super(modelClass);
    }

}