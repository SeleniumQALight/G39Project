package Providers;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;


    public class AddNewProviderTest extends ParentTest {
        final String proCustName = "KoreniukProvider_" + Utils.getDateAndTimeFormated();
        final String proCustAddress = "Antonovycha";
        final String proCustPhone = "5332990";

        @Test
        public void addNewProvider() {
            loginPage.validLogin();
            homePage.checkIfPageOpen();
           // homePage.checkIsAvatarDisplayed();
            homePage.clickOnDictionary();
            homePage.clickOnSubMenuProviders();
//            providersPage.checkIfPageOpen();
      //      providersPage.checkCurrentUrl();
            providersPage.clickOnButtonAdd();
            editProviderPage.checkIfPageOpen();
            editProviderPage.enterProCustName(proCustName);
            editProviderPage.enterProCustAddress(proCustAddress);
            editProviderPage.enterProCustPhone(proCustPhone);
            editProviderPage.choosePrivatePersonFromCheckbox();
            editProviderPage.choosePrivatePersonFromCheckbox("check");
            editProviderPage.chooseIsOurFirmFromCheckbo("uncheck");
        }
    }
