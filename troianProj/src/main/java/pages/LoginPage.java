package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LoginPage was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
//        try {
////            WebElement inputLogin = webDriver.findElement(By.name("_username"));
//
//            inputLogin.clear();
//            inputLogin.sendKeys(Login);
//            logger.info(Login + " was inputted into Login ");
//
//
//        } catch (Exception e) {
//            logger.error("Can not work with element");
//            Assert.fail("Can not work with element");
//        }
    }

    public void enterTextInToInputPass(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
//        try {
////            WebElement inputPass = webDriver.findElement(By.name("_password"));
//
//            inputPassword.clear();
//            inputPassword.sendKeys(Password);
//            logger.info(Password + " was inputed into Password");
//
//        } catch (Exception e) {
//            logger.error("Can not work with element");
//            Assert.fail("Can not work with element");
//        }

    }

    public void clickOnButtonEnter() {
        try {
//            WebElement enterButton = webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button enter was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void loginWithCred(String login, String password) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(password);
        clickOnButtonEnter();
    }
}
