package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void clickOnElement(String locator) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));

        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void selectTextInDD(WebElement dropDown, String text) {
        clickOnElement(dropDown);
        clickOnElement(".//select[@id='spares_spareType']//option[text()='" + text + "']");
    }


    /**
     * visibleText
     *
     * @param dropDown
     * @param text
     */

    public void selectTextInDDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.deselectByVisibleText(text);
            logger.info(text + " was selecte in DD");
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }
}
