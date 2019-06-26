package pages;

import libs.ActionsWithOutElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOutElements actionsWithOutElements;

    public ParentPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOutElements = new ActionsWithOutElements(webDriver);
    }



}
