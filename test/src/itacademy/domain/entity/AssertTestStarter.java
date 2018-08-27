package itacademy.domain.entity;

import itacademy.domain.dao.impl.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BranchTest.class,
        PrivilegeTest.class,
        SubdivisionDaoImplTest.class,
        BranchDaoImplTest.class,
        SystemUserDaoImplTest.class,
        TargetOfJobDaoImplTest.class
})
public class AssertTestStarter {
}
