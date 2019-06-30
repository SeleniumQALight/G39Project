package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextInToInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " inputted into input field");
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }

    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            Assert.fail("Can't work with element");
        }
    }

    public void clickOnElement (String locator) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    //public void clickOnButtonCreate (){
    //    clickOnElement(webDriver.findElement(By.xpath(".//*[@name='add']")));
    //}

    public void selectTextInDrop(WebElement dropDown, String text) {
        clickOnElement(dropDown);
        clickOnElement(".//*[text()='" + text + "']");
    }

    /**
     * method selects visible text in dropdown
     * @param dropDown
     * @param text
     */
    public void selectTextInDropByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in dropdown");
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public boolean isElementDisplayed(String locator) {
        try{
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        }catch (Exception e){
            return false;
        }
    }

}
