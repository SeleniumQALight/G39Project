package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustPage extends ParentPage{
    @FindBy(id = "prov_cus_proCustName")
    private WebElement inputCustName;
    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement inputCustAddress;
    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement inputCustPhone;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement checkOnPriv;
    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement checkOnFir;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    //public EditCustPage(WebDriver webDriver, String partURL) {
    //    super(webDriver, partURL);
    //}

    public EditCustPage(WebDriver webDriver) {
        super(webDriver,"/dictionary/providers/edit");
    }

    public void enterCustName(String custName) {
        actionsWithOurElements.enterTextInToInput(inputCustName, custName);
    }

    public void enterCustAddress(String custAddress) {
        actionsWithOurElements.enterTextInToInput(inputCustAddress, custAddress);
    }

    public void enterCustPhone(String custPhone) {
        actionsWithOurElements.enterTextInToInput(inputCustPhone, custPhone);
    }

    public void checkOnPrivate() {
        actionsWithOurElements.clickOnElement(checkOnPriv);
    }

    public void checkOnFirm() {
        actionsWithOurElements.clickOnElement(checkOnFir);
    }

    public void clickOnbuttonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    //public void checkboxPrivate(WebElement status) {
    //    actionsWithOurElements.setStatusToCheckbox(WebElement, status);
    //}
}
