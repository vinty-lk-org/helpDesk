package itacademy.domain.dao.impl;

import itacademy.domain.entity.Branch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class BranchDaoImplTest {
    private BranchDaoImpl dao;

    @Before
    public void init() {
        dao = BranchDaoImpl.getInstance();
    }


    @Test
    public void findAllTest() {
        Long id1 = dao.save(new Branch("ABC"));
        Long id2 = dao.save(new Branch("DEF"));
        List<Branch> branchList = dao.findAll();

        Assert.assertNotNull(branchList);
        Assert.assertTrue(branchList.size() >= 2);

        for (Branch s : branchList) {
            if (s.getId().equals(id1)) {
                Assert.assertEquals(s.getName(), "ABC");
            }
            dao.delete(id1);
            dao.delete(id2);
        }
    }

    @Test
    public void saveTest() {
        Branch myBranch = new Branch("Запись для теста №1 (save)", "test");
        Long id = dao.save(myBranch);
        Assert.assertNotNull(id);
        Optional<Branch> branchOptional = dao.findById(id);
        String name = "";
        if (branchOptional.isPresent()) {
            name = branchOptional.get().getName();
        }
        Assert.assertEquals(myBranch.getName(), name);
        dao.delete(id);
    }

    @Test
    public void findAllSimple() {
        List<Branch> branchList = BranchDaoImpl.getInstance().findAll();
        for (Branch branch : branchList) {
            System.out.println(branch);
        }
    }


}