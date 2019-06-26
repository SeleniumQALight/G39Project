package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LoginPage was open");
        }catch (Exception e){
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enterTextInToInputLogin(String login)
    {
//        try {
//         //   WebElement inputLogin = webDriver.findElement(By.name("_username"));
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " Was inputted into input Login");
//
//        }catch (Exception e){logger.error("Can not wthis element");
//        Assert.fail("Can not wthis element");
//
//        }
        actionsWithOurElements.enterTextInput(inputLogin,login);
    }

    public void enterTextInToInputPass(String pass) {
//        try{
//           // WebElement inputPass = webDriver.findElement(By.id("password"));
//            inputPass.clear();
//            inputPass.sendKeys(pass);
//            logger.info(pass + " Was inputted into inputPass");
//        }catch (Exception e){logger.error("Can not wthis element");
//            Assert.fail("Can not wthis element");
//
//        }
        actionsWithOurElements.enterTextInput(inputPass, pass);
    }


    public void clickOnButtonVhod() {
        try {
            // WebElement buttonVhod = webDriver.findElement(new By.ByTagName("button"));
            buttonVhod.click();
            logger.info("Button vhod was clicked");

        } catch (Exception e) {
            logger.error("Can not wthis element");
            Assert.fail("Can not wthis element");

        }
    }

    public void loginWithCred(String login, String pass) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(pass);
        clickOnButtonVhod();
    }

    public void validLogin() {
        loginWithCred("Student", "909090");
    }
}
