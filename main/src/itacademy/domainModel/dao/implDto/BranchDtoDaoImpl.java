package itacademy.domainModel.dao.implDto;

import itacademy.domainModel.dao.common.BaseDaoImpl;
import itacademy.domainModel.dao.interfacesDto.BranchDtoDao;
import itacademy.dto.db.BranchDto;

public class BranchDtoDaoImpl extends BaseDaoImpl<BranchDto> implements BranchDtoDao {

    public BranchDtoDaoImpl(Class<BranchDto> modelClass) {
        super(modelClass);
    }
}
