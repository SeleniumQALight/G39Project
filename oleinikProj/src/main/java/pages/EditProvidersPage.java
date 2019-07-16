package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextInput;


public class EditProvidersPage extends ParentPage {

    @FindBy(xpath = ".//input[@id='prov_cus_proCustName']")
    private TextInput inputProviderName;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustAddress']")
    private TextInput inputProviderAddress;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustPhone']")
    private TextInput inputProviderPhone;
    @FindBy(xpath = ".//button[@name='add']")
    private Button buttonCreate;
    @FindBy(xpath = ".//button[@name='delete']")
    private Button buttonDelete;
    @Name("Private person")
    @FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
    private CheckBox checkBoxPrivatePerson;
    @Name("Is our firm")
    @FindBy(xpath = ".//input[@id='prov_cus_isOurFirm']")
    private CheckBox checkBoxisOurFirm;


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

    public void statusToCheckboxPrivatePerson(String status) {
       actionsWithOurElements.setStatusToCheckbox(checkBoxPrivatePerson, status);
    }

    public void setStatusToCheckboxIsOurFirm(String status) {
        actionsWithOurElements.setStatusToCheckbox(checkBoxisOurFirm, status);
    }
}