package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "BuchkivskyiSpare_" + Utils.getDateAndTimeFormated();
    final String spareType = "Механикa ";


    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePage.checkIfPageOpen();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.checkIfPageOpen();
        sparesPage.deleteSpareUntillPresent(spareName);

        sparesPage.clickOnButtonAdd();
        //Homework 20.06.19
        editSparePage.checkIfPageOpen();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropdown(spareType);
        editSparePage.clickOnButtonCreate();

        sparesPage.checkIfPageOpen();
        checkExpectedResult("Can not find spare in List", true, sparesPage.isSpareInList(spareName));

    }
    @After
    public void deleteSpare(){
        sparesPage.deleteSpareUntillPresent(spareName);
    }
}
