package itacademy.domainModel.dao;

import itacademy.domainModel.entity.TargetOfJob;
import itacademy.dto.db.TargetOfJobDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TargetOfJobDtoDaoImplTest {

  @Test
  public void test() {

    TargetOfJobDtoDaoImpl targetOfJobDtoDao = new TargetOfJobDtoDaoImpl(TargetOfJobDto.class);
    List<TargetOfJobDto> all = targetOfJobDtoDao.findAll();
    System.out.println(all);
  }
}