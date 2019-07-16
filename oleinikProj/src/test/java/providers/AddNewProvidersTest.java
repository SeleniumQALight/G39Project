package providers;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProvidersTest extends ParentTest {

final String provaiderName = "Oleynik_" + Utils.getDateAndTimeFormated();
final String providerAddress = "My_address";
final String providerPhone = "My_phone";

    @Test
    public void addNewProvidersPrivatePerson(){
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

        editProvidersPage.statusToCheckboxPrivatePerson("check");
        editProvidersPage.setStatusToCheckboxIsOurFirm("uncheck");
        editProvidersPage.clickOnButtonCreate();

        providersPage.checkCurrentUrl();
        providersPage.checkLablPrivatePerson(provaiderName);

        checkExpectedResult("Can not find provider in list",
                true, providersPage.isProviderInList(provaiderName));
    }


    @Test
    public void addNewProvidersIsOurFirm(){
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

        editProvidersPage.statusToCheckboxPrivatePerson("uncheck");
        editProvidersPage.setStatusToCheckboxIsOurFirm("check");
        editProvidersPage.clickOnButtonCreate();

        providersPage.checkCurrentUrl();
        providersPage.checkLablIsOurFirm(provaiderName);

        checkExpectedResult("Can not find provider in list",
                true, providersPage.isProviderInList(provaiderName));
    }

    @After
    public void deleteProvider(){
        providersPage.deleteProvidersUntilPresent(provaiderName);
    }

}
