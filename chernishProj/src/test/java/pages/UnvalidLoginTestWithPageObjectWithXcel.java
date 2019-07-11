package pages;

import libs.ExcelDriver;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import static pages.ParentPage.configProperties;

@RunWith(Parameterized.class)
public class UnvalidLoginTestWithPageObjectWithXcel extends ParentTest {
    String login, pass;
    public UnvalidLoginTestWithPageObjectWithXcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }


    @Test
    public void unvalidLogin() throws IOException {

        loginPage.loginWithCred(login, pass);

        checkExpectedResult("Avatar should not be present", false, homePage.isAvatarPresent());

        checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());
    }






}
