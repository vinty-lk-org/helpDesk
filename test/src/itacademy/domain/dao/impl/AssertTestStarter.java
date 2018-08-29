package itacademy.domain.dao.impl;

import itacademy.domain.dao.TestDaoHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SubdivisionDaoImplTest.class,
        BranchDaoImplTest.class,
        SystemUserDaoImplTest.class,
        TargetOfJobDaoImplTest.class,
        TestDaoHelperTest.class
})
public class AssertTestStarter {
}
