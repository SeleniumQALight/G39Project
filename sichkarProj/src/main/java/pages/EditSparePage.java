package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(id="spares_spareName")
    private WebElement SpareName;
    @FindBy(xpath = ".//*[@id='spares_spareType']")
    private WebElement typeDropDown;
    @FindBy (tagName = "button")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {

        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareName(String spareName ){
        actionsWithOurElements.enterTextInToInput(SpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
    actionsWithOurElements.selectTextInDropWown(typeDropDown, spareType);
    }

    public void clickOnButtonCreate() {
            try {
            buttonCreate.click();
            logger.info("Button Create was clicked");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnButtonDelete() {
                actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

