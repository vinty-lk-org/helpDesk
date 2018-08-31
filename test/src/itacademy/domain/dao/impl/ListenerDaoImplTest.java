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
        List<Listener> listenerList = dao.findAll();
        Assert.assertNotNull(listenerList);
        Assert.assertTrue(listenerList.size() >= 2);
        for (Listener target : listenerList) {
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
        Listener listener = new Listener();
        listener.setName("Работа №1");
        Long id = dao.save(listener);
        Assert.assertNotNull(id);
        Optional<Listener> optionalListener = dao.findById(id);
        String nameSubdivision = "";
        if (optionalListener.isPresent()) {
            nameSubdivision = optionalListener.get().getName();
        }
        Assert.assertEquals(listener.getName(), nameSubdivision);
        dao.delete(id);
    }
}