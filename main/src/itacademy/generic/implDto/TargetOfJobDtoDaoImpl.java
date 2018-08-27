package itacademy.generic.implDto;

import itacademy.generic.BaseDaoImpl;
import itacademy.generic.interfacesDto.TargetOfJobDtoDao;
import itacademy.generic.db.TargetOfJobDto;

public class TargetOfJobDtoDaoImpl extends BaseDaoImpl<TargetOfJobDto> implements TargetOfJobDtoDao {

  public TargetOfJobDtoDaoImpl(Class<TargetOfJobDto> modelClass) {
    super(modelClass);
  }
}
