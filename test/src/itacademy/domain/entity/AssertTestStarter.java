package itacademy.domain.entity;

import itacademy.domain.dao.impl.BranchDaoImplTest;
import itacademy.domain.dao.impl.SubdivisionDaoImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BranchTest.class,
        PrivilegeTest.class,
        SubdivisionDaoImplTest.class,
        BranchDaoImplTest.class
})
public class AssertTestStarter {
}
