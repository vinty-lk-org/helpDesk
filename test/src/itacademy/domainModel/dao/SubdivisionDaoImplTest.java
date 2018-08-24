package itacademy.domainModel.dao;

import itacademy.domainModel.entity.Subdivision;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubdivisionDaoImplTest {

  @Test
  public void findById() {
  }

  @Test
  public void save() {
    Subdivision subdivision = new Subdivision();
    subdivision.setName("Маркетинг");
    Long id = SubdivisionDaoImpl.getInstance().save(subdivision);

  }
}