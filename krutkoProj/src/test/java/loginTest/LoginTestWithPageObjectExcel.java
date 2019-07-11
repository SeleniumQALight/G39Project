package loginTest;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.util.Map;

import static pages.ParentPage.configProperties;

public class LoginTestWithPageObjectExcel extends ParentTest {
    @Test
    public void validLogIn(){
        ExcelDriver excelDriver = new ExcelDriver();
//        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE, "validLogOn");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());
    }
}
