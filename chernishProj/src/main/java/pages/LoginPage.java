package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(
            name = "_username"
    )
    private WebElement inputLogin;
    @FindBy(
            id = "password"
    )
    private WebElement inputPass;
    @FindBy(
            tagName = "button"
    )
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            this.webDriver.get("http://v3.test.itpmgroup.com");
            this.logger.info("Login page was opened");
        } catch (Exception var2) {
            this.logger.error("Unexpected problem. Cann`t open page");
            Assert.fail("Unexpected problem. Cann`t open page");
        }

    }

    public void enterTextInToInputLogin(String login) {
        this.actionWithOurElements.enterTextIntoInput(this.inputLogin, login);
    }

    public void enterTextInToInputPass(String password) {
        this.actionWithOurElements.enterTextIntoInput(this.inputPass, password);
    }

    public void clickOnButtonVhod() {
        try {
            this.buttonVhod.click();
            this.logger.info("Button Vhod was clicked");
        } catch (Exception var2) {
            this.logger.error("Cann`t work with element");
            Assert.fail("Cann`t work with element");
        }

    }

    public void loginWithCred(String login, String pass) {
        this.openPage();
        this.enterTextInToInputLogin(login);
        this.enterTextInToInputPass(pass);
        this.clickOnButtonVhod();
    }

    public void validLogin() {
        this.loginWithCred("Student", "909090");
    }
}
