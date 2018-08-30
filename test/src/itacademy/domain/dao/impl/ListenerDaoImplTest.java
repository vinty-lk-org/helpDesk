package itacademy.domain.dao.impl;

import itacademy.domain.entity.Listener;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class ListenerDaoImplTest {

    @Test
    public void findAllTest() {
        ListenerDaoImpl dao = ListenerDaoImpl.getInstance();
        Long id1 = dao.save(new Listener("testData1"));
        Long id2 = dao.save(new Listener("testData2"));
        List<Listener> targetOfJobsList = dao.findAll();

        Assert.assertNotNull(targetOfJobsList);
        Assert.assertTrue(targetOfJobsList.size() >= 2);

        for (Listener target : targetOfJobsList) {
            if (target.getId().equals(id1)) {
                Assert.assertEquals(target.getName(), "testData1");
            }
            dao.delete(id1);
            dao.delete(id2);
        }
    }

    @Test
    public void save() {
        ListenerDaoImpl dao = ListenerDaoImpl.getInstance();
        Listener targetOfJob = new Listener();
        targetOfJob.setName("Работа №1");
        Long id = dao.save(targetOfJob);
        Assert.assertNotNull(id);
        Optional<Listener> optionalTargetOfJob = dao.findById(id);
        String nameSubdivision = "";
        if (optionalTargetOfJob.isPresent()) {
            nameSubdivision = optionalTargetOfJob.get().getName();
        }
        Assert.assertEquals(targetOfJob.getName(), nameSubdivision);
        dao.delete(id);
    }

}