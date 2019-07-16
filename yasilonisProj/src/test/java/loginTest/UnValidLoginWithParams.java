package loginTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParams extends ParentTest {
    String login, pass;
    public UnValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                {"Student","906090"},
                {"Login", "906090"},
        });
    }



    @Test
    public void unvalidLogin() {
        loginPage.loginWithCred(login, pass);
        checkExpectedResult("Avatar shoud not be present"
                , false
                , homePage.isAvatarPresent());
    }
}
