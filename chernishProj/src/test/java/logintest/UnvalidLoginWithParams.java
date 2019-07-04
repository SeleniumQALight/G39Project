package logintest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UnvalidLoginWithParams extends ParentTest {
    String login, password;

    public UnvalidLoginWithParams(String login, String password) {
        this.login = login;
        this.password = password;
    }


@Parameterized.Parameters(name="Parameters are {0} and {1}")
public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Login", "909090"},
                {"  ", "  "}
        });
}
    @Test
    public void unvalidLogin(){
        loginPage.loginWithCred(login, password);

        checkExpectedResult("Avatar should not be present", false, homePage.isAvatarPresent());

    }
}
