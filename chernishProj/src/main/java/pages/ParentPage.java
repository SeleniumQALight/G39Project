package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(this.getClass());
    ActionsWithOurElements actionWithOurElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.actionWithOurElements = new ActionsWithOurElements(webDriver);
    }
}