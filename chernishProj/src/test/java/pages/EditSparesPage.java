package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends  ParentPage{
    @FindBy (id = "spares_spareName")
    private WebElement spareNameTextField;

    @FindBy (id="spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy (name="add")
    private WebElement spareAddButton;

    @FindBy(xpath = ".//table[@id='device_list']//tbody//td[contains(text(),'Chernysh')]")
    private WebElement newSpare;

    @FindBy (name="delete")
    private WebElement buttonDelete;



    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit(|/\\d{1,})");
    }

    public void enterSpareName(String spareName) {
        actionWithOurElements.enterTextIntoInput(spareNameTextField, spareName);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        actionWithOurElements.clickOnElement(spareTypeDropDown);
        WebElement optionToSelect = webDriver.findElement(By.xpath(".//select[@id='spares_spareType']/option[text()='"+spareType+"']"));
        actionWithOurElements.clickOnElement(optionToSelect);
    }


    public void clickOnCreate() {
        actionWithOurElements.clickOnElement(spareAddButton);

    }

    public void findNewElementOnList() {
        actionWithOurElements.FindElement(newSpare);
    }

    public void clickOnButtonDelete() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }
}
