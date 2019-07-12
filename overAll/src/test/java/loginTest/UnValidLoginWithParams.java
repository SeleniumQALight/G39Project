package loginTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParams extends ParentTest{
    String login, pass;

    public UnValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                {"Student","906090"},
                {"Login", "909090"}
        });
    }

    @Test
    public void unvalidLogin() {
        loginPage.loginWithCred(login, pass);

        checkExpectedResult("Avatar should not be present"
                , false
                , homePage.isAvatarPresent());
    }
}
