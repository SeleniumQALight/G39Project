package LoginTest;

import org.junit.Test;
import pages.LoginPage;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonVhod();


        checkExpectedResult("Avatar is not present"
        , true
        , homePage.isAvatarPresent());




    }
}
