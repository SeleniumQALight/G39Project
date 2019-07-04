package pages;

import libs.ActionsWithOutElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.regex.Pattern;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOutElements actionsWithOutElements;
    final String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedURL;

    public ParentPage(WebDriver webDriver, String partURL) {

        this.webDriver = webDriver;
        //PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOutElements = new ActionsWithOutElements(webDriver);
        expectedURL = BASE_URL+partURL;
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
