package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

   @FindBy(xpath=".//select[@id='spares_spareType']")
   private WebElement typeDD;
    @FindBy(xpath=".//input[@id='spares_spareName']")
    private WebElement CreateName;
    @FindBy(xpath=".//button[@name='add']")
    private WebElement buttonCreate;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectTextInDD(typeDD,spareType);
    }

    public void enterSpareName(String spareName){
        actionsWithOurElements.enterTextIntoInput(CreateName,spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
}



