package itacademy.domain.dao;

import itacademy.domain.dao.implDto.TargetOfJobDtoDaoImpl;
import itacademy.dto.db.TargetOfJobDto;
import org.junit.Test;

import java.util.List;

public class TargetOfJobDtoDaoImplTest {

  @Test
  public void test() {

    TargetOfJobDtoDaoImpl targetOfJobDtoDao = new TargetOfJobDtoDaoImpl(TargetOfJobDto.class);
    List<TargetOfJobDto> all = targetOfJobDtoDao.findAll();
    System.out.println(all);
  }
}