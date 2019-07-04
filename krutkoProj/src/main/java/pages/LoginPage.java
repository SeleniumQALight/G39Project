package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open login page");
            Assert.fail("Can't open login page");
        }
    }

    public void enterTextInToInputLogin(String login) {
        //  try {
        //     // WebElement inputLogin = webDriver.findElement(By.name("_username"));
        //     inputLogin.clear();
        //      inputLogin.sendKeys(login);
        //      logger.info(login + "inputted into input login");
        //  } catch (Exception e) {
        //      logger.error("Can't work with element");
        //      Assert.fail("Can't work with element");
//
        //  }
        actionsWithOurElements.enterTextInToInput(inputLogin, login);
    }

    public void enterTextInToInputPass(String pass) {
        //  try {
        //     // WebElement inputPass = webDriver.findElement(By.id("password"));
        //      inputPass.clear();
        //      inputPass.sendKeys(pass);
        //      logger.info(pass + "inputted into input password");
        //  } catch (Exception e) {
        //      logger.error("Can't work with element");
        //     Assert.fail("Can't work with element");
        //  }
        actionsWithOurElements.enterTextInToInput(inputPass, pass);
    }

    public void clickOnButtonVhod() {
        try {
            buttonVhod.click();
            logger.info("Button was clicked on");
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void loginWithCred(String login, String pass) {
        openPage();
        checkCurrentURL();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(pass);
        clickOnButtonVhod();
    }

    public void validLogin() {
        loginWithCred("Student", "909090");
    }
}
