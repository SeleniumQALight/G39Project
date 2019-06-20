package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);

    }
    @FindBy(name="_username")
     private WebElement inputLogin;
    @FindBy(id="password")
    private WebElement inputPass;
    @FindBy (tagName = "button")
    private WebElement buttonVhod;



    public void openPage() {

        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LoginPage was opened");

        } catch (Exception e) {

            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }


    }

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

    public void clickOnButtonVhod() {
        try{
  //          WebElement buttonVhod=webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element");
    }
}

    public void loginWithCred(String login, String pass) {
        openPage();
        enterTextIntoInputLogin(login);
        enterTextInToInputPass(pass);
        clickOnButtonVhod();
    }
}



