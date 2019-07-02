package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final  String spareName = "KrutkoSpare";

    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.clickOnButtonAdd();

        //   editSparePage.enterSpareName(spareName);
        //   editSparePage.selectSpareTypeFromDrop("Механика");
        //   editSparePage.clickOnButtonCreate();
    }
}
