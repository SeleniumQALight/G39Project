package providers;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentTest.ParentTest;

public class AddNewProvidersTest extends ParentTest {

final String provaiderName = "Oleynik_" + Utils.getDateAndTimeFormated();
final String providerAddress = "My_address";
final String providerPhone = "My_phone";
final String pp = "Private person";
final String iof = "Is our firm";

@FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
private WebElement privatePerson;

    @Test
    public void addNewProviders(){
        loginPage.validLogin();

        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuProviders();

        providersPage.checkCurrentUrl();
        providersPage.deleteProvidersUntilPresent(provaiderName);
        providersPage.clickOnButtonAdd();

        editProvidersPage.checkCurrentUrl();
        editProvidersPage.enterProviderName(provaiderName);
        editProvidersPage.enterProviderAddress(providerAddress);
        editProvidersPage.enterProviderPhone(providerPhone);
        editProvidersPage.setStatusToCheckbox(iof);
        editProvidersPage.clickOnButtonCreate();

        providersPage.checkCurrentUrl();
        checkExpectedResult("Can not find provider in list",
                true, providersPage.isProviderInList(provaiderName));
    }

    @After
    public void deleteProvider(){
        providersPage.deleteProvidersUntilPresent(provaiderName);
    }
}
