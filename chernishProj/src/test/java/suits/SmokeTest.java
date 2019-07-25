
package suits;

import logintest.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTestWithPageObject.class
        }
)

public class SmokeTest {

}
