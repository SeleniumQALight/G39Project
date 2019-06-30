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

    public void clickOnElement(String locator){
        try{
            clickOnElement(webDriver.findElement(By.xpath(locator)));
            logger.info("Locator" + locator + " is was found");
        }catch (Exception e) {
            logger.error("Can not work wthis element");
            Assert.fail("Can not work wthis element");
        }
    }



    public void clickOnElement(WebElement webElement) {

        try {
            webElement.click();
            logger.info("Element is was clicked");
        } catch (Exception e) {
            logger.error("Can not work wthis element");
            Assert.fail("Can not work wthis element");
        }
    }

    public void enterTextInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " Was inputted into input");
        } catch (Exception e) {
            logger.error("Can not work wthis element");
            Assert.fail("Can not work wthis element");
        }

    }

    public void selectTextInDD(WebElement dropDown, String text) {
        clickOnElement(dropDown);
        clickOnElement(".//select [@id = 'spares_spareType']//*[text() = '" + text + "']");
//        try {
//            webDriver.findElement(By.xpath(".//select [@id = 'spares_spareType']//*[text() = '" + text + "']")).click();
//            logger.info(text + " Was selected in DD");
//        } catch (Exception e) {
//            logger.error("Can not finde " + text);
//            Assert.fail("Can not finde " + text);
//        }

    }

    /**
     * Method selects VISIBLE text in DD
     * @param dropDown
     * @param text
     */
    public  void selectTextInDDByJava(WebElement dropDown, String text){

        try{
            Select select = new Select(dropDown);
            select.deselectByVisibleText(text);
            logger.info(text + " was selected in DD");
        }catch (Exception e) {
            logger.error("Can not work wthis element");
            Assert.fail("Can not work wthis element");
        }

    }

    public boolean isElementDisplayed(WebElement element) {
        try{
            return element.isDisplayed();
        }catch (Exception e){
            return  false;
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
