package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;
    @FindBy(xpath = ".//*[@name = 'delete']")
    private WebElement buttonDelete;

    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text() ='" + spareName + "']");
    }

    public void deleteSpareUtilPresent(String spareName) {
        while (actionsWithOurElements.isElementDisplayed(".//*[text() ='" + spareName + "']")) {
            actionsWithOurElements.clickOnElement(".//*[text() ='" + spareName + "']");
            actionsWithOurElements.isElementDisplayed(buttonDelete);
            actionsWithOurElements.clickOnElement(buttonDelete);
        }

    }
}
