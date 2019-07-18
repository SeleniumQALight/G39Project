package suits;

import loginTest.UnValidLoginWithParams;
import loginTest.loginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testDB.TestDB;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
             loginTestWithPageObject.class,
             UnValidLoginWithParams.class,
             TestDB.class
        }
)
public class SmokeSuit {

}
