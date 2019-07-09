package providers;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {
    final String proCustName = "BuchkivskyiProvider_" + Utils.getDateAndTimeFormated();
    final String proCustAddress = "Kulichki";
    final String proCustPhone = "911";

    @Test
    public void addNewProvider (){
        loginPage.validLogin();
        homePage.checkIfPageOpen();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuProviders();

        providersPage.checkIfPageOpen();
        providersPage.clickOnButtonAdd();
        editProviderPage.checkIfPageOpen();
        editProviderPage.enterProCustName(proCustName);
        editProviderPage.enterProCustAddress(proCustAddress);
        editProviderPage.enterProCustPhone(proCustPhone);
        editProviderPage.choosePrivatePersonFromCheckbox("check");
        editProviderPage.chooseIsOurFirmFromCheckbox("uncheck");
        editProviderPage.clickOnButtonCreate();

        providersPage.checkIfPageOpen();
        System.out.println(proCustName);
        checkExpectedResult("Can not find providers in List", true, providersPage.isProviderInList(proCustName));

        //checkExpectedResult("Can not find new provider in List", true, providersPage.isProviderInList(proCustName, proCustAddress, proCustPhone));

    }



}
