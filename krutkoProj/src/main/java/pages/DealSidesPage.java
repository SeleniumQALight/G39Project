package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealSidesPage extends ParentPage{
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public DealSidesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
