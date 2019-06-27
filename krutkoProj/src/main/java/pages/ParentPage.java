package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

abstract class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    ActionsWithOurElements actionsWithOurElements;
    final String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedURL;

    public ParentPage(WebDriver webDriver, String partURL) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        /*
        инициалузирует елементы которые описаны в FindBy
         */
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedURL = BASE_URL + partURL;
    }

    public void checkCurrentURL(){
       try{
           Assert.assertEquals("URL is not expected", expectedURL, webDriver.getCurrentUrl());
       }catch (Exception e){
           logger.error("Can't get url");
           Assert.fail("Can't get url");
       }
    }

}
