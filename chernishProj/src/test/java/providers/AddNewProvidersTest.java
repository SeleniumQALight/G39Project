package providers;

import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProvidersTest extends ParentTest {

    final String providerName = "Chernysh_"+ Utils.getDateAndTimeFormated();
    final String providerAddress = Utils.getDateAndTimeFormated() + "Chernysh  Test Address";
    final String providerPhone = "123445";

    @Test
    public void NewProvider(){

        loginPage.validLogin();
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuProviders();

        providersPage.checkCurrentUrl();
        providersPage.deleteProvidersUntilPresent(providerName);
        providersPage.clickOnButtonAdd();
        editProvidersPage.enterProviderName(providerName);
        editProvidersPage.enterProviderAddress(providerAddress);
        editProvidersPage.enterProviderPhone(providerPhone);
        editProvidersPage.setPrivatePersonActiveStatus();
        editProvidersPage.creatNewProvider();
        providersPage.checkCurrentUrl();


        Assert.assertTrue("Provider not created as private", providersPage.isProviderAdded(providerName,"1"));

    }

    @After
    public void deleteProvider(){
        providersPage.deleteProvidersUntilPresent(providerName);
    }
}
