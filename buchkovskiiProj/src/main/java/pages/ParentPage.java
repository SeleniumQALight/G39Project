package pages;

import Resources.ConfigProperties;
import libs.ActionsWithOutElements;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.regex.Pattern;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOutElements actionsWithOutElements;
    public static ConfigProperties configProperties =
    ConfigFactory.create(ConfigProperties.class);
    String baseUrl ;
    String expectedURL;

    public ParentPage(WebDriver webDriver, String partURL) {

        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();

        //PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOutElements = new ActionsWithOutElements(webDriver);
        expectedURL = baseUrl +partURL;
    }
    public void checkIfPageOpen () {
        try {
            logger.info(expectedURL);
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("URL is not expected", Pattern.matches(expectedURL,webDriver.getCurrentUrl()), true);
        } catch (Exception e){
            logger.error ("Can't get url"+e);
            Assert.fail ("Can't get url");
        }
    }



}
