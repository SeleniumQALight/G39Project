package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProviderPage  extends ParentPage{

    @FindBy(xpath = ".//input[@id='prov_cus_proCustName']")
    private WebElement providerNameField;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustAddress']")
    private WebElement providerAddressField;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustPhone']")
    private WebElement providerPhoneField;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
    private WebElement privatePerson;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonCreate;


    public EditProviderPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterProCustName(String proCustName) {
        actionsWithOutElements.enterTextIntoInput(providerNameField, proCustName);
    }

    public void enterProCustAddress(String proCustAddress) {
        actionsWithOutElements.enterTextIntoInput(providerAddressField, proCustAddress);
    }

    public void enterProCustPhone(String proCustPhone) {
        actionsWithOutElements.enterTextIntoInput(providerPhoneField, proCustPhone);
    }

    public void choosePrivatePersonFromCheckbox() {
        actionsWithOutElements.clickOnElement(privatePerson);
    }

    public void clickOnButtonCreate() {
        actionsWithOutElements.clickOnElement(buttonCreate);
    }
}
