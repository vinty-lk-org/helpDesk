package itacademy.domainModel.dao;

import itacademy.domainModel.entity.Subdivision;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class SubdivisionDaoImplTest {
  SubdivisionDaoImpl dao = new SubdivisionDaoImpl();

  @Test
  public void save() {
    Subdivision subdivision = new Subdivision();
    subdivision.setName("Маркетинг");
    Long id = dao.save(subdivision);
    Assert.assertNotNull(id);
    Optional<Subdivision> optionalSubdivision = dao.findById(id);
    String nameSubdivision = "";
    if (optionalSubdivision.isPresent()) {
      nameSubdivision = optionalSubdivision.get().getName();
    }
    Assert.assertEquals(subdivision.getName(), nameSubdivision);
    dao.delete(id);
  }
}