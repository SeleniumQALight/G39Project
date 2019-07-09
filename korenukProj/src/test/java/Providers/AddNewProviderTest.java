package Providers;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

import java.sql.SQLOutput;


public class AddNewProviderTest extends ParentTest {
        final String proCustName = "KoreniukProvider_" + Utils.getDateAndTimeFormated();
        final String proCustAddress = "Antonovycha";
        final String proCustPhone = "5332990";

        @Test
        public void addNewProvider() {
            loginPage.validLogin();
            homePage.checkIfPageOpen();
            homePage.clickOnDictionary();
            homePage.clickOnSubMenuProviders();
            providersPage.checkCurrentUrl();
            providersPage.clickOnButtonAdd();
             editProviderPage.enterProCustName(proCustName);
            editProviderPage.enterProCustAddress(proCustAddress);
            editProviderPage.enterProCustPhone(proCustPhone);
            editProviderPage.choosePrivatePersonFromCheckbox();
            editProviderPage.choosePrivatePersonFromCheckbox("check");
            editProviderPage.chooseIsOurFirmFromCheckbo("uncheck");

        }
    }
