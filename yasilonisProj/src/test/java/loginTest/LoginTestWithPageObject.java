package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

//        homePage.checkIsAvatarDisplayed();

        checkExpectedResult("Avatar is not present"
                , true
                , homePage.isAvatarPresent());
    }

    @Test
    public void unvalidLogin() {
        loginPage.loginWithCred("Student", "906090");
        checkExpectedResult("Avatar shoud not be present"
                , false
                , homePage.isAvatarPresent());
    }
}
