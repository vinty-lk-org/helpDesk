package itacademy.domain.dao.impl;

import itacademy.domain.dao.DaoHelper;
import itacademy.domain.entity.Branch;
import org.junit.Test;

public class StrssTest {

    @Test
    public void stressTest() {
        for (int i = 0; i < 100; i++) {
            String randomWord = DaoHelper.getRandomWord(5, 10, false);
            Branch branch = new Branch(randomWord);
            BranchDaoImpl.getInstance().save(branch);
        }
    }
}