package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement spareName;

    @FindBy(xpath = ".//button[@class='btn btn-info']")
    private WebElement buttonCreate;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareName(String name) {
        actionsWithOurElements.enterTextIntoInput(spareName, name);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
}
