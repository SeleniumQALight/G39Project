package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "BuchkivskyiSpare";
    final String spareType = "Механикa";

    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.clickOnButtonAdd();
        //Homework 20.06.19
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropdown(spareType);
        editSparePage.clickOnButtonCreate();

    }
}
