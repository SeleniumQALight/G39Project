package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditProviderPage extends ParentPage {
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
        actionsWithOurElements.enterTextIntoInput(providerNameField, proCustName);
    }

    public void enterProCustAddress(String proCustAddress) {
        actionsWithOurElements.enterTextIntoInput(providerAddressField, proCustAddress);
    }

    public void enterProCustPhone(String proCustPhone) {
        actionsWithOurElements.enterTextIntoInput(providerPhoneField, proCustPhone);
    }

    public void choosePrivatePersonFromCheckbox() {
        actionsWithOurElements.clickOnElement(privatePerson);
    }

    public void choosePrivatePersonFromCheckbox(String status) {
        actionsWithOurElements.setStatusToCheck(privatePerson, status);
    }

    public void chooseIsOurFirmFromCheckbo(String status) {
        actionsWithOurElements.setStatusToCheck(privatePerson, status);
    }

        public void clickOnButtonCreate(){
            actionsWithOurElements.clickOnElement(buttonCreate);
        }

}

