package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProviderPage extends ParentPage {


    @FindBy(xpath = "//input[@id ='prov_cus_proCustName']")
    private WebElement providerName;
    @FindBy(xpath = "//input[@id ='prov_cus_proCustAddress']")
    private WebElement providerAddress;
    @FindBy(xpath = "//input[@id ='prov_cus_proCustPhone']")
    private WebElement providerPhone;
    @FindBy(name = "add")
    private WebElement createNewProvider;
    @FindBy(xpath = "//*[@id='prov_cus_proCustIsFl']")
    private WebElement providerCheckBox;

    public EditProviderPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");

    }


    public void enterProviderName(String text) {
        actionsWithOurElements.enterTextInput(providerName, text);
    }

    public void enterProviderAddress(String text) {
        actionsWithOurElements.enterTextInput(providerAddress, text);
    }

    public void enterProviderPhone(String text) {
        actionsWithOurElements.enterTextInput(providerPhone, text);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(createNewProvider);
    }

    public  void setStatusProviderCheckBox(String statusCheckBox){
        actionsWithOurElements.setStatusToCheckBox(providerCheckBox, statusCheckBox);
    }
}
