package itacademy.domain.dao.implDto;

import itacademy.domain.dao.common.BaseDaoImpl;
import itacademy.domain.dao.interfacesDto.TargetOfJobDtoDao;
import itacademy.dto.db.TargetOfJobDto;

public class TargetOfJobDtoDaoImpl extends BaseDaoImpl<TargetOfJobDto> implements TargetOfJobDtoDao {

  public TargetOfJobDtoDaoImpl(Class<TargetOfJobDto> modelClass) {
    super(modelClass);
  }
}
