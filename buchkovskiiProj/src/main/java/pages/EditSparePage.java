package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement spareNameField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonCreate;

    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement spareTypeDD;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
       super(webDriver, "/dictionary/spares/edit(|/\\d{1,})");
    }

    public void enterSpareName(String spareName) {
        actionsWithOutElements.enterTextIntoInput(spareNameField, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOutElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        actionsWithOutElements.selectTextInDD(spareTypeDD, spareType);
    }

    public void clickOnButtonDelete() {
        actionsWithOutElements.clickOnElement(buttonDelete);

    }
}
