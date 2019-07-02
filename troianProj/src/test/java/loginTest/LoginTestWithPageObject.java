package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {

    @Test
    public void validLogin() {

        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonEnter();

        checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());
    }

    @Test
    public void unvalidLogin() {

        loginPage.loginWithCred("Student", "909090");

        checkExpectedResult("Avatar should not be present", false, homePage.isAvatarPresent());
    }
}
