package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {

    @FindBy(xpath = ".//input[@id='prov_cus_proCustName']")
    private WebElement inputProviderName;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustAddress']")
    private WebElement inputProviderAddress;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustPhone']")
    private WebElement inputProviderPhone;
    @FindBy(xpath = ".//button[@name='add']")
    private WebElement buttonCreate;
    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement buttonDelete;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterProviderName(String providerName) {
        actionsWithOurElements.enterTextInToInput(inputProviderName, providerName);
    }

    public void enterProviderAddress(String providerAddress) {
        actionsWithOurElements.enterTextInToInput(inputProviderAddress, providerAddress);
    }

    public void enterProviderPhone(String providerPhone) {
        actionsWithOurElements.enterTextInToInput(inputProviderPhone, providerPhone);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void setStatusToCheckbox(String checkboxType) {
        actionsWithOurElements.selectElementCheckbox(checkboxType);
    }

}