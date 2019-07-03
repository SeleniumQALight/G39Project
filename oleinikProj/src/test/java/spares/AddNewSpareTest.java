package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "OleynikSpare_" + Utils.getDateAndTimeFormated();

    @Test
    public void  addNewSpare(){
       loginPage.validLogin();
       homePage.checkCurrentUrl();
       homePage.isAvatarPresent();
       homePage.clickOnDictionary();
       homePage.clickOnSubMenuSpare();

       sparesPage.checkCurrentUrl();
       sparesPage.deletSpareUntilPresent(spareName);
       sparesPage.clickOnButtonAdd();

       editSparePage.checkCurrentUrl();
       editSparePage.enterSpareName(spareName);
       editSparePage.selectSpareTypeFromDropDown("Механика");
       editSparePage.clickOnButtonCreate();

       sparesPage.checkCurrentUrl();
       checkExpectedResult("Can not find spare in list",
               true
               , sparesPage.isSpareInList(spareName));

    }

    @After
    public void deletSpare(){
        sparesPage.deletSpareUntilPresent(spareName);
    }
}
