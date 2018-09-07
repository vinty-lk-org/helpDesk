package itacademy.domain.dao.impl;

import itacademy.domain.dao.TestDaoHelperTest;
import itacademy.services.BranchServiceImplTest;
import itacademy.services.SubdivisionServiceImplTest;
import itacademy.services.SystemUserServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BranchDaoImplTest.class,
        ListenerDaoImplTest.class,
        SubdivisionDaoImplTest.class,
        SystemUserDaoImplTest.class,
        TaskDaoImplTest.class,
        TestDaoHelperTest.class,
        PrivilegeDaoImplTest.class,
        SystemUserServiceImplTest.class,
        SubdivisionServiceImplTest.class,
        BranchServiceImplTest.class
})
public class AssertTestStarter {
}