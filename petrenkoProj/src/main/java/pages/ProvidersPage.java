package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage{
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAddNewProvider;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }


    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAddNewProvider);
    }
}
