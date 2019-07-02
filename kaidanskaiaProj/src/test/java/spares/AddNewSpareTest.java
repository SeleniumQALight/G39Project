package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Keidanska@//_"+ Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.checkCurrentUrl();
        sparesPage.deleteSpareDuplicateUntilPresent(spareName);

        sparesPage.clickOnButtonAdd();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName); //HW
        editSparePage.selectSpareTypeFromDropDown("Механикa");//HW find dropdown, open, find element and click
        editSparePage.clickOnButtonCreate(); //HW

        sparesPage.checkCurrentUrl();

        checkExpectedResult("Spare is not found", true, sparesPage.isSpareInList(spareName));


    }

    @After
    public void deleteSpare(){
        sparesPage.deleteSpareDuplicateUntilPresent(spareName);
    }
}
