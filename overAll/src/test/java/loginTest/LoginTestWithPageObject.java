package loginTest;

import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class LoginTestWithPageObject extends ParentTest {
    @Test
    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
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

    @Test
    public void unvalidLogin() {
        loginPage.loginWithCred("Student", "906090");

        checkExpectedResult("Avatar should not be present"
                , false
                , homePage.isAvatarPresent());
    }


}
