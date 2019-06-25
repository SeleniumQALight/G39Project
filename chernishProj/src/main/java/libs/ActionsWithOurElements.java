package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput(WebElement element, String text){
        try{

            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into input");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public void clickOnElement(WebElement webElement) {
        try{
            webElement.click();
            logger.info("Element was clicked");

        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }


    public void FindElement(WebElement webElement) {
        try{
            webElement.isEnabled();
            logger.info("Element exist");

        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }
}
