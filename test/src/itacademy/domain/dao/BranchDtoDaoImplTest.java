package itacademy.domain.dao;

import itacademy.domain.dao.implDto.BranchDtoDaoImpl;
import itacademy.dto.db.BranchDto;
import org.junit.Test;

import java.util.List;

public class BranchDtoDaoImplTest {

    @Test
    public void test() {

        BranchDtoDaoImpl branchDtoDao = new BranchDtoDaoImpl(BranchDto.class);
        List<BranchDto> all = branchDtoDao.findAll();
        System.out.println(all);
    }
}