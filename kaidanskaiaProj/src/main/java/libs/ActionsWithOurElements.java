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

    public void clickOnElement(WebElement webElement) {
        try {
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
    public void setCheckBoxStatus(WebElement webElement, String status) {
        try{
            if (webElement.isSelected()==true){
                if(status=="check"){
                    logger.info("Checkbox is selected by default");
                }
                if (status == "uncheck"){
                    clickOnElement(webElement);
                    logger.info("Checkbox was unselected by click");
                }
            }
            if (webElement.isSelected()==false){
            if (status=="check"){
                clickOnElement(webElement);
                logger.info("Checkbox selected by click");
            }
            if (status == "uncheck"){
               logger.info("Checkbox is not selected by default");

            }
        }


        }

         catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with  element");
        }

    }
}