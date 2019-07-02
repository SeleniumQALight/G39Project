package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName")
    private WebElement ProCustName;
    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement ProCustAdress;
    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement ProCustPhone;
    @FindBy(tagName = "button")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditProvidersPage(WebDriver webDriver, String partUrl) {
        super(webDriver, "/dictionary/providers");
    }

    public void enterProCustName(String proCustName) {
        actionsWithOurElements.enterTextInToInput(ProCustName, proCustName);
    }

    public void enterProCustAddress(String proCustAdress) {
        actionsWithOurElements.enterTextInToInput(ProCustAdress, proCustAdress);
    }

    public void enterProCustPhone(String proCustPhone) {
        actionsWithOurElements.enterTextInToInput(ProCustPhone, proCustPhone);
    }

    public void clickOnButtonCreate() {
        try {
            buttonCreate.click();
            logger.info("Button Create was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}