package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (name  ="_username")
    private WebElement inputLogin;

    @FindBy (id = "password")
    private WebElement inputPass;

    @FindBy (tagName = "button")
    private WebElement buttonVhod;

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Unexpected problem. Cann`t open page");
            Assert.fail("Unexpected problem. Cann`t open page");
        }
    }


    public void enterTextInToInputLogin(String login) {
/*        try{
            //WebElement inputLogin = webDriver.findElement(By.name("_username"));
            inputLogin.clear();
            inputLogin.sendKeys(login);
            logger.info(login + "was inputted into input login");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }*/

        actionWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterTextInToInputPass(String password) {
/*        try{
            //WebElement inputPass = webDriver.findElement(By.id("password"));

            inputPass.clear();
            inputPass.sendKeys(password);
            logger.info(password + "password was inputted correctly");
        }catch(Exception e){
            logger.error("Cann`t work with element");
            Assert.fail("Cann`t work with element");
        }*/
        actionWithOurElements.enterTextIntoInput(inputPass, password);

    }

    public void clickOnButtonVhod() {
        try {
            //WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
            buttonVhod.click();
            logger.info("Button Vhod was clicked");

        }catch(Exception e){
            logger.error("Cann`t work with element");
            Assert.fail("Cann`t work with element");
        }
    }

    public void loginWithCred(String login, String pass) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(pass);
        clickOnButtonVhod();

    }
}
