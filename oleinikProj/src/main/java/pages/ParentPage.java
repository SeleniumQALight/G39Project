package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Pattern;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements  actionsWithOurElements;
    final  String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = BASE_URL + partUrl;

    }

    public void checkCurrentUrl (){
        try {
            logger.info(expectedUrl);
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("URL is not expected", Pattern.matches(expectedUrl,
                    webDriver.getCurrentUrl()),true);
        }catch (Exception e){
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }
}
