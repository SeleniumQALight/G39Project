package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Chernysh_"+ Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare (){
        loginPage.validLogin();
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.checkCurrentUrl();
        sparesPage.deleteSpareUntilPresent(spareName);
        sparesPage.clickOnButtonAdd();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(spareName);
        editSparesPage.selectSpareTypeFromDropdown("Механикa");
        editSparesPage.clickOnCreate();
        editSparesPage.findNewElementOnList();



        checkExpectedResult("Cann`t find spare in the list", true, sparesPage.isSpareInList(spareName));

    }

    @After
    //test
    public void deleteSpare(){
        sparesPage.deleteSpareUntilPresent(spareName);
    }
}
