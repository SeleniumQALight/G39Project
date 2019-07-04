package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;
    @FindBy(name = "add")
    private WebElement buttonCreate;
    @FindBy(id = "spares_spareType")
    private WebElement spareDrop;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit(|/\\d{1, })");
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextInToInput(inputSpareName, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeFromDrop(String spareType) {
        actionsWithOurElements.selectTextInDrop(spareDrop, spareType);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}