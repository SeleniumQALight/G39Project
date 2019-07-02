package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage  extends ParentPage{

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public ProvidersPage (WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOutElements.clickOnElement(buttonAdd);
    }

    public boolean isProvidersInList(String proCustName) {

        return actionsWithOutElements.isElementDisplayed(".//*[text()='" + proCustName + "']");
    }


}
