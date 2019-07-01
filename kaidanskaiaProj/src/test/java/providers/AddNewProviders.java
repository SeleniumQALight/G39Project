package providers;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviders extends ParentTest {
    final String proCustName = "Keidanska" + Utils.getDateAndTimeFormated();
    final String proCustAddress = "Pluk" + Utils.getDateAndTimeFormated();
    final String proCustPhone = "990099900000" + Utils.getDateAndTimeFormated();
@Test
    public void addNewProviders() {
    loginPage.validLogin();
    homePage.checkCurrentUrl();
    homePage.isAvatarPresent();
    homePage.clickOnDictionary();
    homePage.clickOnSubMenuProviders();

    providersPage.checkCurrentUrl();
    providersPage.clickOnButtonAdd();

    editProvidersPage.checkCurrentUrl();
    editProvidersPage.enterProcustName(proCustName);
    editProvidersPage.enterProcustAddress(proCustAddress);
    editProvidersPage.enterProcustPhone(proCustPhone);
    editProvidersPage.setChBPrivatePersonStatus("check");
    editProvidersPage.setChBIsOurFirmStatus("uncheck");
    editProvidersPage.clickOnButtonCreate();

    providersPage.checkCurrentUrl();

    checkExpectedResult("Provider is not private person", true, providersPage.isProviderPrivatePerson(proCustName,proCustAddress,proCustPhone));


    }

//    @After
//    public void deleteProvider(){
//    providersPage.deleteProvidersDuplicateUntilPresent(proCustName, proCustAddress, proCustPhone);
//    }
}
