package itacademy.domain.dao.impl;

import itacademy.domain.entity.Status;
import org.junit.Test;

import java.util.List;

public class StatusDaoImplTest {

    @Test
    public void findAllStatus() {
        List<Status> statuses = StatusDaoImpl.getInstance().findAllStatus();
        for (Status status : statuses) {
            System.out.println(status);
        }
    }
}