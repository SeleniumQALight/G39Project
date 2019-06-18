package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com/");
            logger.info("Login page is opend");
        } catch (Exception e){
            logger.error("Can't open Loginpage");
            Assert.fail("Can't open LoginPage");
        }
    }
}
