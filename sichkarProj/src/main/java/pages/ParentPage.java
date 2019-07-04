package pages;

import javafx.scene.Parent;
import libs.ActionsWithOurElements;
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
    ActionsWithOurElements actionsWithOurElements;
    final String BASE_URL = "http://v3.test.itpmgroup.com";
    String expectedUrl;


    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
//        PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = BASE_URL + partUrl;
        }
    public  void checkCurrentUrl(){
        try{
            //http://v3.test.itpmgroup.com/dictionary/spares/edit/\\d{1,} - проверка динамического URL
            logger.info(expectedUrl);
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("URL is not expected"
                                , Pattern.matches(expectedUrl
                                , webDriver.getCurrentUrl())
                                , true
                                );
        }catch (Exception e){
            logger.error("Can not get url" + e);
            Assert.fail();
        }
    }

}
