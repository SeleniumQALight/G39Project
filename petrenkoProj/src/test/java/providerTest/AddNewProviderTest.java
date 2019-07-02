package providerTest;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {
    final String providerName = "Name" + Utils.getDateAndTimeFormated();
    final String providerAddress = "Address" + Utils.getDateAndTimeFormated();
    final String providerPhone = "Phone" + Utils.getDateAndTimeFormated();
    final boolean checkStatusCheckBox = true;
    final boolean unCheckStatusCheckBox = true;

    @Test
    public void addNewSpare() {
        loginPage.validLogin();
      //  homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplaed();

        homePage.clickOnDictionary();
        homePage.clickOnSubMenuProvider();
       // providersPage.checkCurrentUrl();
       // providersPage.deleteSpareUtilPresent(unitProvider);


        providersPage.clickOnButtonAdd();
       // editProviderPage.checkCurrentUrl();

        editProviderPage.enterProviderName(providerName);
        editProviderPage.enterProviderAddress(providerAddress);
        editProviderPage.enterProviderPhone(providerPhone);
        editProviderPage.selectProviderCheckBox(checkStatusCheckBox);
        editProviderPage.clickOnButtonCreate();
        providersPage.checkCurrentUrl();
        //checkExpectedResult("Can not find in list", true, providersPage.isSpareInList(spareName));


    }

    @After
    public void deleteSpare() {
      //  providersPage.deleteProviderUtilPresent(unitProvider);
    }

}
