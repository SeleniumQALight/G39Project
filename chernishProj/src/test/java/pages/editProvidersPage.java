package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class editProvidersPage extends ParentPage {
    @FindBy(id="prov_cus_proCustName")
    private WebElement providerNameTextField;

    @FindBy(id="prov_cus_proCustAddress")
    private WebElement providerAddressTextField;

    @FindBy(id="prov_cus_proCustPhone")
    private WebElement providerPhoneTextField;

    @FindBy(name = "add")
    private WebElement addNewProvider;

    @FindBy(name = "delete")
    private WebElement clickOnButtonDelete;

    @FindBy(id="prov_cus_proCustIsFl")
    private WebElement privatePersonCheckBox;

    public editProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterProviderName(String providerName){
        actionWithOurElements.enterTextIntoInput(providerNameTextField, providerName);
    }

    public void enterProviderAddress(String providerAddress){
        actionWithOurElements.enterTextIntoInput(providerAddressTextField, providerAddress);
    }

    public void enterProviderPhone(String providerPhone){
        actionWithOurElements.enterTextIntoInput(providerPhoneTextField, providerPhone);
    }

    public void setPrivatePersonActiveStatus(){
        actionWithOurElements.changeCheckboxState(privatePersonCheckBox, true);
    }

    public void setPrivatePersonNotActiveStatus(){
        actionWithOurElements.changeCheckboxState(privatePersonCheckBox, false);
    }





    public void clickOnButtonDelete(){
        actionWithOurElements.clickOnElement(clickOnButtonDelete);
    }


    public void creatNewProvider(){
        actionWithOurElements.clickOnElement(addNewProvider);
    }

}
