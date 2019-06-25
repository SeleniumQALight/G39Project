package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Keidanska@//";
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

//        sparesPage.deleteSpareDuplicateUntilPresent(spareName);

        sparesPage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareName); //HW
        editSparePage.selectSpareTypeFromDropDown("Механикa");//HW find dropdown, open, find element and click
        editSparePage.clickOnButtonCreate(); //HW

        checkExpectedResult("Spare is not found", true, sparesPage.isSpareInList(spareName));


    }

//    @After
//    public void deleteSpare(){
//        sparesPage.deleteSpareDuplicateUntilPresent(spareName);
//    }
}
