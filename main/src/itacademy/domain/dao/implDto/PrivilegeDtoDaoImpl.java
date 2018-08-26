package itacademy.domain.dao.implDto;

import itacademy.domain.dao.common.BaseDaoImpl;
import itacademy.domain.dao.interfacesDto.PrivilegeDtoDao;
import itacademy.dto.db.BranchDto;
import itacademy.dto.db.PrivilegeDto;

public class PrivilegeDtoDaoImpl extends BaseDaoImpl<PrivilegeDto> implements PrivilegeDtoDao {

    public PrivilegeDtoDaoImpl(Class<PrivilegeDto> modelClass) {
        super(modelClass);
    }

}