package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.regex.Pattern;

abstract public class ParentPage {
    ActionsWithOurElements actionsWithOurElements;
     WebDriver webDriver;
     Logger logger = Logger.getLogger(getClass());
     protected static ConfigProperties configProperties =
             ConfigFactory.create(ConfigProperties.class);
       String baseUrl;
     String expectedUrl;

    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
     //  baseUrl = "http://v3.test.itpmgroup.com" ;
        //PageFactory.initElements(webDriver,this);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = baseUrl + partUrl;
    }
        public  void checkCurrentUrl(){
            try {
                logger.info(expectedUrl);
                logger.info(webDriver.getCurrentUrl());
                Assert.assertEquals("URL is not expected", Pattern.matches(expectedUrl , webDriver.getCurrentUrl()),true);
            }catch (Exception e){
                logger.error("Can not get URL" + e);
                Assert.fail("Can not get URL");
            }

        }

}
