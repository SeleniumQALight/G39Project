package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement spareNameField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement create;

    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement typeDD;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }
    public void enterSpareName(String spareName) {
        actionsWithOutElements.enterTextIntoInput(spareNameField, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOutElements.clickOnElement(create);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        actionsWithOutElements.selectTextInDD(typeDD, spareType);
    }

}
