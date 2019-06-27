package spares;

import org.junit.Test;
import pages.EditSparePage;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Kirichenko";
    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePages.isAvatarPresent();
        homePages.clickOnDictionary();
        homePages.clickOnSubMenuSpare();

        sparesPage.clickOnButtonAdd();

      //  EditSparePage.enterSpareName(spareName);
        //EditSparePage.selectSpareTypeFromDropDown("Механикa");
     //   EditSparePage.clickOnButtonCreate();



    }
}
