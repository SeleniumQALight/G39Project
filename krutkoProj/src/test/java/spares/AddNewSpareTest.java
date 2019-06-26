package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "KrutkoSpare";

    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.deleteSpareUntilPresent(spareName);

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
