package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    final  String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedURL;


    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedURL = BASE_URL + partUrl;
    }

    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("URL is not expected",expectedURL,webDriver.getCurrentUrl());
        } catch (Exception e){
            logger.error("Can not get URL" + e);
            Assert.fail("Can not get URL");
        }
    }

}
