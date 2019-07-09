package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "KrutkoSpare " + Utils.getDateAndTimeFormated();

    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePage.checkCurrentURL();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.checkCurrentURL();
        sparesPage.deleteSpareUntilPresent(spareName);

        sparesPage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDrop("Механика");
        editSparePage.clickOnButtonCreate();

        sparesPage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDrop("Механика");
        editSparePage.clickOnButtonCreate();

        sparesPage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDrop("Механика");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Can't find spare in List", true, sparesPage.isSpareInList(spareName));
    }

    @After
    public void deleteSpare() {
        sparesPage.deleteSpareUntilPresent(spareName);
    }
}
