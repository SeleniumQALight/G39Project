package Pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;

    public static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    final String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedUrl;

    public ParentPage (WebDriver webDriver, String partURL){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = BASE_URL + partURL;
    }
    public void checkCurrentUrl(){
        try {
            Assert.assertEquals("URL is nor expected"
            ,expectedUrl
            , webDriver.getCurrentUrl());
        }catch (Exception e){
            logger.error("Can not get URL" + e);
            Assert.fail("Can not get URL");
        }
    }

}
