package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage  {

    @FindBy(xpath=".//select[@id='spares_spareType']")
    private WebElement spareDD;
    @FindBy(xpath=".//input[@id='spares_spareName']")
    private WebElement inputSpareName;
    @FindBy(xpath=".//button[@name='add']")
    private WebElement buttonCreate;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectTextInDD(spareDD,spareType);
    }

    public void enterSpareName(String spareName){
        actionsWithOurElements.enterTextInToInput(inputSpareName,spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
}
