package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "OleynikSpare";
    @Test
    public void  addNewSpare(){
       loginPage.validLogin();
       homePage.iaAvatarPresent();
       homePage.clickOnDictionary();
       homePage.clickOnSubMenuSpare();

       sparesPage.clickOnButtonAdd();

       editSparePage.enterSpareName(spareName);
       editSparePage.selectSpareTypeFromDropDown("Механика");
       editSparePage.clickOnButtonCreate();

    }

}
