package libs;

import javafx.scene.control.CheckBox;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10 , wait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextInToInput(TypifiedElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into " + element.getName());
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(WebElement webElement) {
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(TypifiedElement webElement) {
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element" + " " + webElement.getName() + " " + "was clicked" );
        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void selectTextInDD (TypifiedElement dropDown, String text) {
        clickOnElement(dropDown);
        clickOnElement(".//*[text()='" + text + "']");
        logger.info(text + " " + "was selected in" + " " + dropDown);
    }


    /**
     * Method selects VISIBLE text in DD
     * @param dropDown
     * @param text
     */
    public void selectTextInDDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select((dropDown));
            select.deselectByVisibleText(text);
            logger.info(text + " was selected in DD");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element
                    .isDisplayed();
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

    public void clickOnElement(String locator) {
        try{
           clickOnElement(webDriver.findElement(By.xpath(locator)));
            logger.info("Element was clicked");
        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public  void setStatusToCheckbox(TypifiedElement checkBox, String status){
        boolean isStatusCheck = "check".equals(status.toLowerCase());
        boolean isStatusUncheck = "uncheck".equals(status.toLowerCase());
        if( isStatusCheck|| isStatusUncheck){
           if(checkBox.isSelected() && isStatusCheck){
    logger.info("CheckBox" + " " + checkBox.getName() + " " + "is already checked");
            }else if(checkBox.isSelected() && isStatusCheck) {
               clickOnElement(checkBox);
           }else if(!checkBox.isSelected() && isStatusCheck) {
               clickOnElement(checkBox);
           }else if(!checkBox.isSelected() && isStatusUncheck){
               logger.info("CheckBox" + " " + checkBox.getName() + " " + "is already uncheck");
           }
        }else {
            Assert.fail("Status should be 'check' or 'uncheck'");
        }
    }
}
