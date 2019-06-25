package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogIn(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());
    }

    @Test
    public void unvalidLogIn() {
        loginPage.loginWithCred("student", "906090");

        checkExpectedResult("Avatar should not be present",false, homePage.isAvatarPresent());
    }
}
