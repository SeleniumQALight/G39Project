package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @FindBy(name="_username")
    private TextInput inputLogin;
    @FindBy(id="password")
    private TextInput inputPass;
    @FindBy (tagName = "button")
    private WebElement buttonVhod;


    @Step
    public void openPage() {

        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LoginPage was opened");

        } catch (Exception e) {

            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }


    }

    @Step
    public void enterTextIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin,login);
    }
      //  try {
          //  WebElement inputLogin = webDriver.findElement(By.name("_username"));
       //     inputLogin.clear();
        //    inputLogin.sendKeys(login);
     //       logger.info(login + "was inputted into Login");

    //    } catch (Exception e) {

    //        logger.error("Can not work with element");
     //       Assert.fail("Can not work with element");
 //       }
   // }

    @Step
    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextIntoInput(inputPass,pass);
    }

      //  try {
      //      WebElement inputPass = webDriver.findElement(By.id("password"));
       //     inputPass.clear();
        //    inputPass.sendKeys(pass);
      //      logger.info(pass + "was inputted into inputPass");
     //   } catch (Exception e) {
      //      logger.error("Can not work with element ");
       //     Assert.fail("Can not work with element");
       // }
    //}
      @Step
    public void clickOnButtonVhod() {
        try{
           WebElement buttonVhod=webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element");
    }
}
    @Step
    public void loginWithCred(String login, String pass) {
        openPage();
        checkCurrentUrl();
        enterTextIntoInputLogin(login);
        enterTextInToInputPass(pass);
        clickOnButtonVhod();
    }
    @Step
    public void validLogin() {
    loginWithCred("Student","909090");
    }
}



