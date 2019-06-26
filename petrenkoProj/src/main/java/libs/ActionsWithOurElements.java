package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOnElement(WebElement webElement) {

        try {
            webElement.click();
            logger.info("Element is was cleaced");
        } catch (Exception e) {
            logger.error("Can not wthis element");
            Assert.fail("Can not wthis element");
        }
    }

    public void enterTextInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " Was inputted into input");
        } catch (Exception e) {
            logger.error("Can not wthis element");
            Assert.fail("Can not wthis element");
        }

    }

    public void selectTextInDD(WebElement webElement, String text) {
        webElement.click();
        try {
            webDriver.findElement(By.xpath(".//select [@id = 'spares_spareType']//*[text() = '" + text + "']")).click();
            logger.info(text + " Was selected in DD");
        } catch (Exception e) {
            logger.error("Can not finde " + text);
            Assert.fail("Can not finde " + text);
        }

    }

}
