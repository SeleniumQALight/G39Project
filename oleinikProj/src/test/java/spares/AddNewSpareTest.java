package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "OleynikSpare";
    @Test
    public void  addNewSpare(){
       loginPage.validLogin();
       homePage.isAvatarPresent();
       homePage.clickOnDictionary();
       homePage.clickOnSubMenuSpare();

       sparesPage.deletSpareUntilPresent(spareName);
       sparesPage.clickOnButtonAdd();

       editSparePage.enterSpareName(spareName);
       editSparePage.selectSpareTypeFromDropDown("Механика");
       editSparePage.clickOnButtonCreate();

       checkExpectedResult("Can not find spare in list",
               true
               , sparesPage.isSpareInList(spareName));

    }

    @After
    public void deletSpare(){
        sparesPage.deletSpareUntilPresent(spareName);
    }
}
