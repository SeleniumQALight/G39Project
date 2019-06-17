package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        } catch (Exception e){
            logger.error("Can not open login page");
            Assert.fail("Can not open login page");
        }
    }

    public boolean isLoginFormPresent(){
        try {
            return webDriver.findElement(By.id("password")).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}