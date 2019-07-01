package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionWithOurElements;

    final String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = BASE_URL + partUrl;

    }

    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("URL is not expected", expectedUrl, webDriver.getCurrentUrl());

        }catch(Exception e){
            logger.error("Can not get URL"+ e);
            Assert.fail("Can not get URL");
        }
    }


}
