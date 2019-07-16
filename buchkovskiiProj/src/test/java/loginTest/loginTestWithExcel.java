package loginTest;

import Resources.ConfigProperties;
import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;

public class loginTestWithExcel extends ParentTest {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataValidLogin.get("login").toString());
        loginPage.enterTextInToInputPassword(dataValidLogin.get("pass").toString());
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not pressent", true, homePage.isAvatarPresent());
    }

}
