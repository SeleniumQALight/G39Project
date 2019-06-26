package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.soap.Text;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger= Logger.getLogger(getClass());
    public  ActionsWithOurElements(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void enterTextIntoInput(WebElement element,String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into Login");

        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }
    public void selectTextInDD (WebElement webElement, String text){
        try {
            webElement.click();
            logger.info("Element was clicked");
            webDriver.findElement(By.xpath(".//*[text()='" + text + "']")).click();
            logger.info("Element was clicked");
        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
}
