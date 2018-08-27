package itacademy.generic.implDto;

import itacademy.generic.db.BranchDto;
import org.junit.Test;

import java.util.List;

public class BranchDtoDaoImplTest {

    @Test
    public void test() {

        BranchDtoDaoImpl branchDtoDao = new BranchDtoDaoImpl(BranchDto.class);
        BranchDto branchDto = new BranchDto();
        List<BranchDto> all = branchDtoDao.findAll();
        System.out.println(all);
    }
}