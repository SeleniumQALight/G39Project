package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOutElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput (WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was imported into input");
        } catch (Exception e){
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }


}
