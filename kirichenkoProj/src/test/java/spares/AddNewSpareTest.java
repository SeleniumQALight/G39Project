package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import pages.EditSparePage;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Kirichenko_" + Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePages.checkCurrentUrl();
        homePages.checkIsAvatarDisplayed();
        homePages.clickOnDictionary();
        homePages.clickOnSubMenuSpare();

        sparesPage.checkCurrentUrl();
        sparesPage.deleteSpareUntilPresent(spareName);
        sparesPage.clickOnButtonAdd();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Механикa");
        editSparePage.clickOnButtonCreate();

        sparesPage.checkCurrentUrl();

       checkExpectedResult("Can not find spare in list",true,sparesPage.isSpareInList(spareName));

    }
    @After
    public void deleteSpare(){
        sparesPage.deleteSpareUntilPresent(spareName);
    }
}
