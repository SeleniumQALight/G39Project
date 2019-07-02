package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id="password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextInToInput(inputLogin, login);
       /* try {
           // WebElement inputLogin = webDriver.findElement(By.name("_username"));
            inputLogin.clear();
            inputLogin.sendKeys(login);
            logger.info(login + " was inputted into input Login");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }*/

    }

    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextInToInput(inputPass, pass);
        /*ry {

            inputPass.clear();
            inputPass.sendKeys(pass);
            logger.info(pass + " was inputted into input Password");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }*/

    }

    public void clickOnButtonVhod() {
        try {
           // WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button vhod was clicked");

        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void loginWithCred(String login, String pass) {
        openPage();
        checkCurrentUrl();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(pass);
        clickOnButtonVhod();
    }

    public void validLogin() {
        loginWithCred("Student", "909090");
    }
}
