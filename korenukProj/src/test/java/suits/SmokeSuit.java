package suits;

import loginTest.LoginTestWithPageObject;
import loginTest.UnvalidLoginWithParams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTestWithPageObject.class,
                UnvalidLoginWithParams.class
        }
)

public class SmokeSuit {
}
