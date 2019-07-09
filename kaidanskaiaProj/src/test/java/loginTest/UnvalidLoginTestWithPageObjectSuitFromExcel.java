package loginTest;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static pages.ParentPage.configProperties;

@RunWith(Parameterized.class)
public class UnvalidLoginTestWithPageObjectSuitFromExcel extends ParentTest {
     String login, pass;

    public UnvalidLoginTestWithPageObjectSuitFromExcel(String login, String pass) {
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
    public void invalidLogin() {
        loginPage.loginWithCred(login,pass);
        checkExpectedResult("Avatar should not be present", false, homePage.isAvatarPresent());
    }
}
