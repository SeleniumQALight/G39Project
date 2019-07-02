package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage{
    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(id = "spares_spareType")
    private WebElement spareDD;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver,"/dictionary/spares/edit(|/\\d{1,})");
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectTextInDD(spareDD, spareType);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

//    public void selectSpareTypeFromDropDown(String spareType) {
//        actionsWithOurElements.selectTextInDD(typeDD, spareType);
//    }
}
