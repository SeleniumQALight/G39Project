package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage {
    WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    Logger logger = Logger.getLogger(getClass());
}
