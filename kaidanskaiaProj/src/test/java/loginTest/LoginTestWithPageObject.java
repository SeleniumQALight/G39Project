package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());


    }

    @Test
    public void invalidLogin() {
        loginPage.loginWithCred("Student", "909080");
        checkExpectedResult("Avatar should not be present", false, homePage.isAvatarPresent());
    }
}
