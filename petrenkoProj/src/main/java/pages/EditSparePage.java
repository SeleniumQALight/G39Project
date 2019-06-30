package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy(xpath = ".//input[@id = 'spares_spareName']")
    private WebElement inputSpareName;
    @FindBy (xpath = ".//button[@name = 'add']")
    private WebElement buttonAddNewSpare;
    @FindBy (xpath = ".//select [@id = 'spares_spareType']")
    private WebElement typeDD;

    private WebElement typeSpareName;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void selectSpareTypeFromDropDown(String text) {

        actionsWithOurElements.selectTextInDD(typeDD, text);
    }

    public void enterSpareName(String text) {
        actionsWithOurElements.enterTextInput(inputSpareName, text);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonAddNewSpare);
    }


}
