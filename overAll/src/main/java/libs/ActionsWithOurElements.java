package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10 , wait15;

    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextIntoInput (WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into input");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
//            wait10.until(ExpectedConditions.not(
//                    ExpectedConditions.elementToBeClickable(webElement)));
            webElement.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(String locator){
        try{
            clickOnElement(webDriver.findElement(
                    By.xpath(locator)));
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void selectTextInDD(WebElement dropDown, String text) {
        clickOnElement(dropDown);
        clickOnElement(".//*[text()='" + text + "']");
    }

    /**
     * Method selects VISIBLE text in DD
     * @param dropDown
     * @param text
     */
    public void selectTextInDDByJava(WebElement dropDown, String text){
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DD");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element
                    .isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementDisplayed(String locator) {
        try{
            return isElementDisplayed(
                    webDriver.findElement(By.xpath(locator)));
        }catch (Exception e){
            return false;
        }
    }

    public void setStatusToCheckBox(WebElement checkBox
            , String status){
        boolean isStatusCheck = "check".equals(status.toLowerCase());
        boolean isStatusUnCheck = "uncheck".equals(status.toLowerCase());
        if ( isStatusCheck || isStatusUnCheck
                ){
            if (checkBox.isSelected() && isStatusCheck){
                logger.info("CheckBox is already checked");
            }else if (checkBox.isSelected() && isStatusUnCheck){
                clickOnElement(checkBox);
            }else if (!checkBox.isSelected() && isStatusCheck){
                clickOnElement(checkBox);
            }else if (!checkBox.isSelected() && isStatusUnCheck){
                logger.info("CheckBox is already uncheck");
            }
        }else {
            Assert.fail("Status should be 'check' or 'uncheck'");
        }
    }


//    public void selectTextInDD (WebElement webElement, String text){
//        webElement.click();
//        webDriver.findElement(By.xpath(".//*[text()='" + text + "']")).click();
//    }
}
