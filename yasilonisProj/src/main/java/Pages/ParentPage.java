package Pages;

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
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;

    public static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

//    final String baseUrl = configProperties.base_url();
    String baseUrl;
    String expectedUrl;

    public ParentPage (WebDriver webDriver, String partURL){
        this.webDriver = webDriver;
    baseUrl= configProperties.base_url();
//        PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)),this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = baseUrl + partURL;
    }
    public void checkCurrentUrl(){
        try {
//            System.out.println(
//            Pattern.matches("http://v3.test.itpmgroup.com/dictionary/spares/edit/\\d{1,}
//            |http://v3.test.itpmgroup.com/dictionary/spares/edit", "http://v3.test.itpmgroup.com/dictionary/spares/edit/"));
            Assert.assertEquals("URL is nor expected"
                    , Pattern.matches(expectedUrl
                    , webDriver.getCurrentUrl())
                    , true
                    );
        }catch (Exception e){
            logger.error("Can not get URL" + e);
            Assert.fail("Can not get URL");
        }
    }

}
