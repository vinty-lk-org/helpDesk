package itacademy.domain.dao.impl;

import itacademy.domain.entity.Subdivision;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class SubdivisionDaoImplTest {

    @Test
    public void save() {
        SubdivisionDaoImpl dao = SubdivisionDaoImpl.getInstance();
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

    @Test
    public void findAllTest() {
        SubdivisionDaoImpl dao = SubdivisionDaoImpl.getInstance();
        Long id1 = dao.save(new Subdivision("ABC"));
        Long id2 = dao.save(new Subdivision("DEF"));
        List<Subdivision> subdivisionList = dao.findAll();

        Assert.assertNotNull(subdivisionList);
        Assert.assertTrue(subdivisionList.size() >= 2);

        for (Subdivision s : subdivisionList) {
            if (s.getId().equals(id1)) {
                Assert.assertEquals(s.getName(), "ABC");
            }
            dao.delete(id1);
            dao.delete(id2);
        }
    }
}