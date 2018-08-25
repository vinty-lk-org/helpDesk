package itacademy.domainModel.dao.implDto;

import itacademy.domainModel.dao.common.BaseDaoImpl;
import itacademy.domainModel.dao.interfacesDto.TargetOfJobDtoDao;
import itacademy.dto.db.TargetOfJobDto;

public class TargetOfJobDtoDaoImpl extends BaseDaoImpl<TargetOfJobDto> implements TargetOfJobDtoDao {

  public TargetOfJobDtoDaoImpl(Class<TargetOfJobDto> modelClass) {
    super(modelClass);
  }
}
