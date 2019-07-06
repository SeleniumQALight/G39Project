package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class EditSparePage extends ParentPage  {

    @Name("dropDown")
    @FindBy(xpath=".//select[@id='spares_spareType']")
    private TextBlock spareDD;
    @FindBy(xpath=".//input[@id='spares_spareName']")
    private TextInput inputSpareName;
    @FindBy(xpath=".//button[@name='add']")
    private Button buttonCreate;
    @FindBy(name = "delete")
    private Button buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit(|/\\d{1,})");
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

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
