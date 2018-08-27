package itacademy.generic.implDto;

import itacademy.generic.BaseDaoImpl;
import itacademy.generic.interfacesDto.BranchDtoDao;
import itacademy.generic.db.BranchDto;

public class BranchDtoDaoImpl extends BaseDaoImpl<BranchDto> implements BranchDtoDao {

    public BranchDtoDaoImpl(Class<BranchDto> modelClass) {
        super(modelClass);
    }
}
