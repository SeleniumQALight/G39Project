package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage  {

    @FindBy(xpath=".//select[@id='spares_spareType']")
    private WebElement typeDD;
    @FindBy(xpath=".//input[@id='spares_spareName']")
    private WebElement createSpare;
    @FindBy(xpath=".//button[@name='add']")
    private WebElement buttonSozdat;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectTextInDD(typeDD,spareType);
    }

    public void enterSpareName(String spareName){
        actionsWithOurElements.enterTextInToInput(createSpare,spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonSozdat);
    }
}
