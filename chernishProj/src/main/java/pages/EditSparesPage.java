package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends ParentPage {
    @FindBy(
            id = "spares_spareName"
    )
    private WebElement spareNameTextField;
    @FindBy(
            id = "spares_spareType"
    )
    private WebElement spareTypeDropDown;
    @FindBy(
            name = "add"
    )
    private WebElement spareAddButton;
    @FindBy(
            xpath = ".//table[@id='device_list']//tbody//td[contains(text(),'Chernysh')]"
    )
    private WebElement newSpare;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareName(String spareName) {
        this.actionWithOurElements.enterTextIntoInput(this.spareNameTextField, spareName);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        this.actionWithOurElements.clickOnElement(this.spareTypeDropDown);
        WebElement optionToSelect = this.webDriver.findElement(By.xpath(".//select[@id='spares_spareType']/option[text()='" + spareType + "']"));
        this.actionWithOurElements.clickOnElement(optionToSelect);
    }

    public void clickOnCreate() {
        this.actionWithOurElements.clickOnElement(this.spareAddButton);
    }

    public void findNewElementOnList() {
        this.actionWithOurElements.FindElement(this.newSpare);
    }
}
