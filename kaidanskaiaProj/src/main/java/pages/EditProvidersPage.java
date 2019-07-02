package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {
    @FindBy (id="prov_cus_proCustName")
    private WebElement inputName;
    @FindBy (id = "prov_cus_proCustAddress")
    private WebElement inputAddress;
    @FindBy (id = "prov_cus_proCustPhone")
    private WebElement inputPhone;
    @FindBy (name = "add")
    private WebElement buttonCreate;
    @FindBy (id = "prov_cus_proCustIsFl")
    private WebElement privatePerson;
    @FindBy (id = "prov_cus_isOurFirm")
    private WebElement isOurFirm;
    @FindBy (name = "delete")
    private WebElement buttonDelete;


    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }


    public void enterProcustName(String proCustName) {
        actionsWithOurElements.enterTextIntoInput(inputName, proCustName);

    }

    public void enterProcustAddress(String proCustAddress) {
        actionsWithOurElements.enterTextIntoInput(inputAddress, proCustAddress);
    }

    public void enterProcustPhone(String proCustPhone) {
        actionsWithOurElements.enterTextIntoInput(inputPhone, proCustPhone);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void setChBPrivatePersonStatus(boolean status) {
        actionsWithOurElements.setCheckBoxStatus(privatePerson, status);
    }

    public void setChBIsOurFirmStatus(boolean status) {
        actionsWithOurElements.setCheckBoxStatus(isOurFirm, status);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
