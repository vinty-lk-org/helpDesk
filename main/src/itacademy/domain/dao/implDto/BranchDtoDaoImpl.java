package itacademy.domain.dao.implDto;

import itacademy.domain.dao.common.BaseDaoImpl;
import itacademy.domain.dao.interfacesDto.BranchDtoDao;
import itacademy.dto.db.BranchDto;

public class BranchDtoDaoImpl extends BaseDaoImpl<BranchDto> implements BranchDtoDao {

    public BranchDtoDaoImpl(Class<BranchDto> modelClass) {
        super(modelClass);
    }
}
