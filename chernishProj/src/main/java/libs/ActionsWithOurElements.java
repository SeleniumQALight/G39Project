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

    public void enterTextIntoInput(WebElement element, String text){
        try{

            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into input");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }



    public void clickOnElement(WebElement webElement) {
        try{
            webElement.click();
            logger.info("Element was clicked");

        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public void changeCheckboxState(WebElement checkBox, boolean select){
        if(select){
            if(!checkBox.isSelected()){
                clickOnElement(checkBox);
            }
        }else{
            if(checkBox.isSelected()){
                clickOnElement(checkBox);
            }
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



    /**
     * method selects visible text in DD
     * @param dropDown
     * @param text
     */
    public void seelctTextIDDByJava(WebElement dropDown, String text){
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text+" was selected in DD");

        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }



    public void FindElement(WebElement webElement) {
        try{
            webElement.isEnabled();
            logger.info("Element exist");

        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }


    public boolean isElementDispalyed(WebElement element) {

        try{
            return element.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isElementDispalyed(String locator) {
       try{
           return isElementDispalyed(webDriver.findElement(By.xpath(locator)));

       }catch(Exception e){
           return false;
       }
    }
}
