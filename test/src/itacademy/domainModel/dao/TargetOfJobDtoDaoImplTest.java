package itacademy.domainModel.dao;

import itacademy.domainModel.entity.TargetOfJob;
import itacademy.dto.db.TargetOfJobDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class TargetOfJobDtoDaoImplTest {
  private Class<TargetOfJobDto> targetOfJobDtoClass = TargetOfJobDto.class;

  @Test
  public void test() {

    TargetOfJobDtoDaoImpl targetOfJobDtoDao = new TargetOfJobDtoDaoImpl(targetOfJobDtoClass);
    targetOfJobDtoDao.findAll();
  }
}