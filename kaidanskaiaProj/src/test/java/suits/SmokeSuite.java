package suits;

import loginTest.LoginTestWithPageObject;
import loginTest.UnValidLoginWithParams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testDB.TestDB;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTestWithPageObject.class,
                UnValidLoginWithParams.class,
                TestDB.class
        }
)
public class SmokeSuite {


}
