package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name="_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        } catch (Exception e){
            logger.error("Can not open login page");
            Assert.fail("Can not open login page");
        }
    }

    public boolean isPasswordFieldPresent(){
        try {
            //return webDriver.findElement(By.id("password")).isDisplayed();
            return inputPassword.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void enterTextIntoInputLogin(String login) {
//        try{
//           // WebElement inputLogin = webDriver.findElement(By.name("_username"));
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login+" was entered into input Login");
//
//        } catch (Exception e){
//            logger.error("Can not work with  element");
//            Assert.fail("Can not work with  element");
//        }
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterTextIntoInputPassword(String password) {
//        try{
//            // WebElement inputPassword = webDriver.findElement(By.id("password"));
//            inputPassword.clear();
//            inputPassword.sendKeys(password);
//            logger.info(password+" was entered into input Password");
//
//        } catch (Exception e){
//            logger.error("Can not work with element");
//            Assert.fail("Can not work with  element");
//        }

        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
        try{
            //WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button Vhod was clicked");

        } catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }
    }
}
