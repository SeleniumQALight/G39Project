package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    final String spareName = "RadulenkoSpare_"
            + Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.checkCurrentUrl();
        sparesPage.deletSpareUntilPresent(spareName);
        sparesPage.clickOnButtonAdd();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Механикa");
        editSparePage.clickOnButtonCreate();

        sparesPage.checkCurrentUrl();
        checkExpectedResult("Can not find spare in list"
                ,true
                ,sparesPage.isSpareInList(spareName));

    }
//http://v3.test.itpmgroup.com/dictionary/spares
    @After
    public void deleteSpare(){
        sparesPage.deletSpareUntilPresent(spareName);
    }
}
