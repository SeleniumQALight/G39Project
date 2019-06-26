package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOutElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was imported into input");
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }


    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void selectTextInDD(WebElement element, String sparetype) {
        try {
            element.click();
            webDriver.findElement(By.xpath(".//select[@id='spares_spareType']//option[text()='" + sparetype + "']")).click();
            logger.info("Text in DropDown was finded");
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }


}
