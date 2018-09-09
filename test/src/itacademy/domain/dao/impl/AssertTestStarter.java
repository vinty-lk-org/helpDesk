package itacademy.domain.dao.impl;

import itacademy.domain.dao.TestDaoHelperTest;
import itacademy.domain.services.*;
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
        BranchServiceImplTest.class,
        SystemUserServiceImplTest.class,
        SubdivisionServiceImplTest.class,
        PrivilegeServiceImplTest.class,
        BranchServiceImplTest.class,
        TaskServiceImplTest.class
})
public class AssertTestStarter {
}