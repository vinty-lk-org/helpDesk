package itacademy.services;

import itacademy.dto.models.SubdivisionDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SubdivisionServiceImplTest {

  @Test
  public void getAllSubdivisionDto() {
    List<SubdivisionDto> subdivisionDtoList = SubdivisionServiceImpl.getInstance().getAllSubdivisionDto();
    Assert.assertNotNull(subdivisionDtoList);
//    subdivisionDtoList.forEach(System.out::println);
  }
}