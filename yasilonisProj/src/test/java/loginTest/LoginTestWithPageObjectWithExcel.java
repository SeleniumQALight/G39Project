package loginTest;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static Pages.ParentPage.configProperties;

public class LoginTestWithPageObjectWithExcel extends ParentTest {
    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataForValidLogin.get("login").toString());
        loginPage.enterTextInToInputPassword(dataForValidLogin.get("pass").toString());
        loginPage.clickOnButtonVhod();

//        homePage.checkIsAvatarDisplayed();

        checkExpectedResult("Avatar is not present"
                , true
                , homePage.isAvatarPresent());
    }


}
