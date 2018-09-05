package itacademy.services;

import itacademy.domain.dao.impl.SubdivisionDaoImpl;
import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.dto.SubdivisionDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubdivisionServiceImplTest {

  @Test
  public void getAllSubdivisionDto() {
    List<SubdivisionDto> subdivisionDtoList = SubdivisionServiceImpl.getInstance().getAllSubdivisionDto();
    Assert.assertNotNull(subdivisionDtoList);
//    subdivisionDtoList.forEach(System.out::println);
  }
}