package LoginTest;

import org.junit.Test;
import pages.LoginPage;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();


    }
}
