package itacademy.domain.dao.impl;

import itacademy.domain.dao.TestDaoHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BranchDaoImplTest.class,
        ListenerDaoImplTest.class,
        SubdivisionDaoImplTest.class,
        SystemUserDaoImplTest.class,
        TaskDaoImplTest.class,
        TestDaoHelperTest.class
})
public class AssertTestStarter {
}
