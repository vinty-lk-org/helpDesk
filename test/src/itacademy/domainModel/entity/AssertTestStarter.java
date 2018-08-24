package itacademy.domainModel.entity;

import itacademy.domainModel.dao.BranchDaoImplTest;
import itacademy.domainModel.dao.SubdivisionDaoImplTest;
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
