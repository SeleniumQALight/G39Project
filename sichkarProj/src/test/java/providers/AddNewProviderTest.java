package providers;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.Wait;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {
    final String ProCustName = "Sichkar"
            + Utils.getDateAndTimeFormated();
    final String ProCustAdress = "Adress"
            + Utils.getDateAndTimeFormated();
    final String ProCustPhone = "Phone"
            + Utils.getDateAndTimeFormated();

    @Test

    public void addNewProvider () {
        loginPage.validLogin();
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnMenuSubProviders();
        providersPage.checkCurrentUrl();
        providersPage.deliteProviderUntilPresent(ProCustName);
        providersPage.clickOnButtonAdd();
        editProvidersPage.checkCurrentUrl();
        editProvidersPage.clickOnButtonCreate();
        editProvidersPage.enterProCustName(ProCustName);
        editProvidersPage.enterProCustAddress(ProCustAdress);
        editProvidersPage.enterProCustPhone(ProCustPhone);
        editProvidersPage.setPrivatePersonCheckBox();
        editProvidersPage.setFirmCheckBox();
        editProvidersPage.clickOnButtonCreate();
        providersPage.checkCurrentUrl();

        checkExpetedResult("Can not find provider in list"
                ,true
                ,providersPage.isProviderInList(ProCustName));

    }
        @After
    public void deleteProvider() {providersPage.deliteProviderUntilPresent(ProCustName);}

}
