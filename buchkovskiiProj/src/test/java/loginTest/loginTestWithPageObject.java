package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

import javax.naming.ldap.PagedResultsControl;

public class loginTestWithPageObject extends ParentTest {
    @Test
    public  void validLogin(){
        loginPage.openPage();
    }

}
