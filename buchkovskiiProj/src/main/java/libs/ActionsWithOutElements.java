package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOutElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;

    public ActionsWithOutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
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

    public void enterTextIntoInput (TypifiedElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was imported into input"+ element.getName());
        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            // Example for not syntax wait10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)))
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

    public void selectStatusCheckbox(WebElement checkBox){
        clickOnElement(checkBox);
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

    public void setCheckBoxStatus(WebElement checkBox, String status){
        boolean isStatusCheck = "check".equals(status.toLowerCase());
        boolean isStatusUncheck = "uncheck".equals(status.toLowerCase());

        if (isStatusCheck || isStatusUncheck ){
            if (checkBox.isSelected() && isStatusCheck){
                logger.info("Checkbox has been already selected");
            } else if (checkBox.isSelected() && isStatusUncheck){
                clickOnElement(checkBox);
                logger.info("Checkbox unselected by click");
            } else  if (!checkBox.isSelected() && isStatusCheck){
                clickOnElement(checkBox);
                logger.info("Checkbox is selected by click");
            } else if (!checkBox.isSelected() && isStatusUncheck){
                logger.info("Checkbox has been already unselected");
            }

        } else {
            Assert.fail("Status should be 'check' or 'uncheck'");
        }
    }



}
