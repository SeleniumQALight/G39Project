package pages;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;

public class LoginTestWithPageObjectWithXcel extends ParentTest {
    @Test
    public void validLogin() throws IOException {

        ExcelDriver excelDriver = new ExcelDriver();
        //here could be problem
        Map dataValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");

        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataValidLogin.get("Login").toString());
        loginPage.enterTextInToInputPass(dataValidLogin.get("Pass").toString());
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());
    }






}
