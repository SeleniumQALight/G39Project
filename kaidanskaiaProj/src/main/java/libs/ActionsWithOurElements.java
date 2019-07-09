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

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;

    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextIntoInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered into input");

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }

    }

    public void enterTextIntoInput(TypifiedElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered into input '" + element.getName()+"'");

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }

    }

    public void clickOnElement(WebElement webElement) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            // Example for not syntax wait10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)))
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }
    }

    public void clickOnElement(String locator){
        try{
            clickOnElement(webDriver.findElement(By.xpath(locator)));

        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }
    }

    public void selectTextFromDDList(WebElement dropDown, String text) {
      try{ clickOnElement(dropDown);
          clickOnElement(".//*[text()='"+ text +"']");
          logger.info("Element was selected");
      } catch (Exception e) {
          logger.error("Can not work with element");
          Assert.fail("Can not work with  element");
      }
    }

    /**
     * Method selects VISIBLE text in DD list
     * @param dropDown
     * @param text
     */
    public void selectTextInDDByJava(WebElement dropDown, String text){
        try{
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text+ " was selected in DD");

        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }
    }


    public boolean isElementDisplayed(WebElement element) {
        try{
            return element.isDisplayed();
        } catch(Exception e){
            return false;
        }

    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));

        } catch (Exception e){
            return false;}
    }

    /**
     * Method check if line with 3 defined fields contains expected text in 4th field
     * @param td1
     * @param td2
     * @param td3
     * @param text
     * @return
     */
    public boolean isLineContainText(String td1, String td2, String td3, String text) {
         try{ return webDriver.findElement(By.xpath(".//tr[.//td[1][text()='"+td1+"']" +
                 " and .//td[2][text()='"+td2+"'] " +
                 "and .//td[3][text()='"+td3+"']]//td[4]")).getText().contentEquals(text);

        } catch (Exception e){
            return false;}
    }

    /**
     * Method check or uncheck checkbox
     * @param webElement
     * @param status
     */
    public void setCheckBoxStatus(WebElement webElement, boolean status) {
        try{
            if (webElement.isSelected()&& status){
                    logger.info("Checkbox is selected by default");
                } else if (webElement.isSelected() && !status){
                    clickOnElement(webElement);
                    logger.info("Checkbox was unselected by click");
                }
            else if (!webElement.isSelected()&& status){
                clickOnElement(webElement);
                logger.info("Checkbox selected by click");
            } else  if (!webElement.isSelected() && !status){
               logger.info("Checkbox is not selected by default");

            }
        }
         catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
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