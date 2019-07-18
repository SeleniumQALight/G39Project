package loginTest;

import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("906090");
        loginPage.clickOnButtonVhod();

//        homePage.checkIsAvatarDisplayed();

        checkExpectedResult("Avatar is not present"
                , true
                , homePage.isAvatarPresent());
    }


    public void unvalidLogin() {
        loginPage.loginWithCred("Student", "906090");

        checkExpectedResult("Avatar should not be present"
                , false
                , homePage.isAvatarPresent());
    }


}
