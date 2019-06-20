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

    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy (id = "password")
    private WebElement inputPassword;

    @FindBy (tagName = "button")
    private WebElement buttonVhod;

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com/");
            logger.info("Login page is opened");
        } catch (Exception e){
            logger.error("Can't open LoginPage");
            Assert.fail("Can't open LoginPage");
        }
    }

    public void enterTextInToInputLogin(String login) {
        actionsWithOutElements.enterTextIntoInput(inputLogin, login);

//        try {
//            //WebElement inputLogin = webDriver.findElement(By.name("_username"));
//
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was imported into input Login");
//        } catch (Exception e){
//            logger.error("Can't work with element");
//            Assert.fail("Can't work with element");
//        }
    }

    public void enterTextInToInputPassword(String password) {
        actionsWithOutElements.enterTextIntoInput(inputPassword, password);
//        // to-do
//        try{ //WebElement inputPassword = webDriver.findElement(By.id ("password"));
//            inputPassword.clear();
//            inputPassword.sendKeys(password);
//            // to-do
//            logger.info(password + " was imported into input Password");
//        } catch (Exception e){
//            // to-do
//            logger.error("Can't work with element");
//            Assert.fail("Can't work with element");
//        }
    }

    public void clickOnButtonVhod() {
        try {//WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button vhod was clicked");
        }catch (Exception e){
            // to-do
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void loginWithCred(String login, String password) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPassword(password);
        clickOnButtonVhod();
    }
}
